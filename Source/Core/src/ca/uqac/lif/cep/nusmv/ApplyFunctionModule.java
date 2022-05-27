package ca.uqac.lif.cep.nusmv;

import ca.uqac.lif.symbolif.ArrayVariable;
import ca.uqac.lif.symbolif.Condition;
import ca.uqac.lif.symbolif.Conjunction;
import ca.uqac.lif.symbolif.Disjunction;
import ca.uqac.lif.symbolif.Equivalence;
import ca.uqac.lif.symbolif.LogicModule;
import ca.uqac.lif.symbolif.Variable;

public class ApplyFunctionModule extends LogicModule
{

	public ApplyFunctionModule(String name, Variable[] parameters) {
		super(name, parameters);
		// TODO Auto-generated constructor stub
	}

	/*@ non_null @*/ public static Condition buildInitialState(int Q_up, int Q_b)
	{
		Conjunction big_and = new Conjunction();
		return big_and;
	}
	
	public static Condition numFronts(ArrayVariable porch_c1, ArrayVariable porch_b1, ArrayVariable porch_c2, ArrayVariable porch_b2, int Q_p, ArrayVariable buffer_c1, ArrayVariable buffer_b1, ArrayVariable buffer_c2, ArrayVariable buffer_b2, int Q_b, int n)
	{
		Disjunction or = new Disjunction();
		{
			Conjunction and = new Conjunction();
			and.add(BeepBeepModule.hasTotalPipe(porch_c1, porch_b1, Q_p, buffer_c1, buffer_b1, Q_b, n));
			and.add(BeepBeepModule.minTotalPipe(porch_c2, porch_b2, Q_p, buffer_c2, buffer_b2, Q_b, n));
			or.add(and);
		}
		{
			Conjunction and = new Conjunction();
			and.add(BeepBeepModule.minTotalPipe(porch_c1, porch_b1, Q_p, buffer_c1, buffer_b1, Q_b, n));
			and.add(BeepBeepModule.hasTotalPipe(porch_c2, porch_b2, Q_p, buffer_c2, buffer_b2, Q_b, n));
			or.add(and);
		}
		return or;
	}
	
	public static Condition frontsVsBackPorch(ArrayVariable porch_c1, ArrayVariable porch_b1, ArrayVariable porch_c2, ArrayVariable porch_b2, int Q_p, ArrayVariable buffer_c1, ArrayVariable buffer_b1, ArrayVariable buffer_c2, ArrayVariable buffer_b2, int Q_b, ArrayVariable backporch_c1, ArrayVariable backporch_b1, int Q_bp)
	{
		Conjunction and = new Conjunction();
		for (int i = 0; i <= Q_bp - 1; i++)
		{
			Equivalence eq = new Equivalence();
			eq.add(ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_bp, i));
			eq.add(BeepBeepModule.hasLength(backporch_c1, backporch_b1, Q_bp, i));
			and.add(eq);
		}
		return and;
	}
}
