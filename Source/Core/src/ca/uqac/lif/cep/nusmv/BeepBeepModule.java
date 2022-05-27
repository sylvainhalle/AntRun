package ca.uqac.lif.cep.nusmv;

import ca.uqac.lif.symbolif.Condition;
import ca.uqac.lif.symbolif.Conjunction;
import ca.uqac.lif.symbolif.ConstantFalse;
import ca.uqac.lif.symbolif.Disjunction;
import ca.uqac.lif.symbolif.LogicModule;
import ca.uqac.lif.symbolif.Negation;
import ca.uqac.lif.symbolif.Variable;

import static ca.uqac.lif.symbolif.ConstantFalse.FALSE;
import static ca.uqac.lif.symbolif.ConstantTrue.TRUE;

import ca.uqac.lif.symbolif.ArrayAccess;
import ca.uqac.lif.symbolif.ArrayVariable;
import ca.uqac.lif.symbolif.BooleanArrayAccessCondition;

public abstract class BeepBeepModule extends LogicModule
{
	public BeepBeepModule(String name, Variable[] parameters)
	{
		super(name, parameters);
	}

	/*@ non_null @*/ public static Condition minLength(ArrayVariable array_c, ArrayVariable array_b, int Q, int n)
	{
		Conjunction and = new Conjunction();
		if (n < 0 || n >= Q)
		{
			return FALSE;
		}
		if (n == 0)
		{
			return TRUE;
		}
		for (int i = 0; i <= n - 1; i++)
		{
			and.add(BooleanArrayAccessCondition.get(ArrayAccess.get(array_b, i)));
		}
		return and;
	}
	
	/*@ non_null @*/ public static Condition hasLength(ArrayVariable array_c, ArrayVariable array_b, int Q, int n)
	{
		Conjunction and = new Conjunction();
		if (n < 0 || n >= Q)
		{
			return FALSE;
		}
		for (int i = 0; i <= n - 1; i++)
		{
			and.add(BooleanArrayAccessCondition.get(ArrayAccess.get(array_b, i)));
		}
		for (int i = n; i <= Q - 1; i++)
		{
			Negation not = new Negation();
			not.add(BooleanArrayAccessCondition.get(ArrayAccess.get(array_b, i)));
			and.add(not);
		}
		return and;
	}
	
	public static Condition atBuffer(ArrayVariable buffer_c, ArrayVariable buffer_b, int Q_b, int m, int n)
	{
		if (m != n || n < 0 || m < 0 || m >= Q_b)
		{
			return FALSE;
		}
		return BooleanArrayAccessCondition.get(ArrayAccess.get(buffer_b, m));
	}
	
	public static Condition atPorch(ArrayVariable porch_c, ArrayVariable porch_b, int Q_p, ArrayVariable buffer_c, ArrayVariable buffer_b, int Q_b, int m, int n)
	{
		if (n < 0 || n >= Q_b + Q_p || m < 0 || m >= Q_p)
		{
			return FALSE;
		}
		Conjunction and = new Conjunction();
		and.add(BooleanArrayAccessCondition.get(ArrayAccess.get(porch_b, m)));
		and.add(hasLength(buffer_c, buffer_b, Q_b, n - m));
		return and;
	}
	
	public static Condition minTotalPipe(ArrayVariable porch_c, ArrayVariable porch_b, int Q_p, ArrayVariable buffer_c, ArrayVariable buffer_b, int Q_b, int n)
	{
		Disjunction or = new Disjunction();
		for (int j = 0; j <= n; j++)
		{
			int k = n - j;
			Conjunction and = new Conjunction();
			and.add(minLength(buffer_c, buffer_b, Q_b, j));
			and.add(minLength(porch_c, porch_b, Q_p, k));
			or.add(and);
		}
		return or;
	}
	
	public static Condition hasTotalPipe(ArrayVariable porch_c, ArrayVariable porch_b, int Q_p, ArrayVariable buffer_c, ArrayVariable buffer_b, int Q_b, int n)
	{
		Disjunction or = new Disjunction();
		for (int j = 0; j <= n; j++)
		{
			int k = n - j;
			Conjunction and = new Conjunction();
			and.add(hasLength(buffer_c, buffer_b, Q_b, j));
			and.add(hasLength(porch_c, porch_b, Q_p, k));
			or.add(and);
		}
		return or;
	}
}
