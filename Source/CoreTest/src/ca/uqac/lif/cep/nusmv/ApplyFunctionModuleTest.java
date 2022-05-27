package ca.uqac.lif.cep.nusmv;

import org.junit.Test;

import static org.junit.Assert.*;

import ca.uqac.lif.symbolif.ArrayVariable;
import ca.uqac.lif.symbolif.Assignment;
import ca.uqac.lif.symbolif.BooleanDomain;
import ca.uqac.lif.symbolif.Condition;
import ca.uqac.lif.symbolif.Domain;

public class ApplyFunctionModuleTest
{
	protected static Domain s_domLetters = new Domain("a", "b", "c");
	
	protected static Domain s_domBooleans = new BooleanDomain();
	
	@Test
	public void testNumFronts1()
	{
		// There are 8 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 3);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, true, true, true, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, true, true, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testNumFronts2()
	{
		// There are 8 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 8);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, true, true, true, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, true, true, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testNumFronts3()
	{
		// There are 6 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 6);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, true, true, true, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, true, true, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, false, false, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testNumFronts4()
	{
		// There are 6 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 6);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, true, true, true, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, false, false, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testNumFronts5()
	{
		// There are 5 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 5);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, false, false, false, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, false, false, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testNumFronts6()
	{
		// There are 5 complete fronts in this test case
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.numFronts(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, false, false, false, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, false, false, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testFrontsVsBackPorch1()
	{
		// There are 5 complete fronts in this test case
		int Q_b = 5, Q_p = 5, Q_bp = Math.min(Q_b, Q_p);
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		ArrayVariable backporch_c = new ArrayVariable("pb_c2", s_domLetters, Q_p);
		ArrayVariable backporch_b = new ArrayVariable("pb_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.frontsVsBackPorch(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, backporch_c, backporch_b, Q_bp);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, false, false, false, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, false, false, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		a.set(backporch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(backporch_b, new Object[] {true, true, true, true, true});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testFrontsVsBackPorch2()
	{
		// There are 5 complete fronts in this test case
		int Q_b = 5, Q_p = 5, Q_bp = Math.min(Q_b, Q_p);
		ArrayVariable buffer_c1 = new ArrayVariable("b_c1", s_domLetters, Q_b);
		ArrayVariable buffer_b1 = new ArrayVariable("b_b1", s_domBooleans, Q_b);
		ArrayVariable porch_c1 = new ArrayVariable("p_c1", s_domLetters, Q_p);
		ArrayVariable porch_b1 = new ArrayVariable("p_b1", s_domBooleans, Q_p);
		ArrayVariable buffer_c2 = new ArrayVariable("b_c2", s_domLetters, Q_b);
		ArrayVariable buffer_b2 = new ArrayVariable("b_b2", s_domBooleans, Q_b);
		ArrayVariable porch_c2 = new ArrayVariable("p_c2", s_domLetters, Q_p);
		ArrayVariable porch_b2 = new ArrayVariable("p_b2", s_domBooleans, Q_p);
		ArrayVariable backporch_c = new ArrayVariable("pb_c2", s_domLetters, Q_p);
		ArrayVariable backporch_b = new ArrayVariable("pb_b2", s_domBooleans, Q_p);
		Condition c = ApplyFunctionModule.frontsVsBackPorch(porch_c1, porch_b1, porch_c2, porch_b2, Q_p, buffer_c1, buffer_b1, buffer_c2, buffer_b2, Q_b, backporch_c, backporch_b, Q_bp);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b1, new Object[] {true, true, true, true, false});
		a.set(porch_c1, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b1, new Object[] {true, false, false, false, false});
		a.set(buffer_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b2, new Object[] {true, true, false, false, false});
		a.set(porch_c2, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b2, new Object[] {true, true, true, true, false});
		a.set(backporch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(backporch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
}
