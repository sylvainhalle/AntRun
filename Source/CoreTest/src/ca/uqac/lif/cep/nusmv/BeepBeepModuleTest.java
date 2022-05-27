package ca.uqac.lif.cep.nusmv;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uqac.lif.symbolif.ArrayVariable;
import ca.uqac.lif.symbolif.Assignment;
import ca.uqac.lif.symbolif.BooleanDomain;
import ca.uqac.lif.symbolif.Condition;
import ca.uqac.lif.symbolif.Domain;

public class BeepBeepModuleTest
{
	protected static Domain s_domLetters = new Domain("a", "b", "c");
	
	protected static Domain s_domBooleans = new BooleanDomain();
	
	@Test
	public void testLambdaAtLeast1()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.minLength(q_c, q_b, Q, 3);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testLambdaAtLeast2()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.minLength(q_c, q_b, Q, 5);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testLambdaAtLeast3()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.minLength(q_c, q_b, Q, 6);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testLambdaAtLeast4()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.minLength(q_c, q_b, Q, 0);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testLambdaEquals1()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.hasLength(q_c, q_b, Q, 3);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testLambdaEquals2()
	{
		int Q = 5;
		ArrayVariable q_c = new ArrayVariable("q_c", s_domLetters, Q);
		ArrayVariable q_b = new ArrayVariable("q_b", s_domBooleans, Q);
		Condition c = BeepBeepModule.hasLength(q_c, q_b, Q, 4);
		assertNotNull(c);
		q_c.setValues("a", "b", "c", "a", "b");
		q_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(q_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(q_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testAtBuffer1()
	{
		int Q_b = 5;
		ArrayVariable buffer_c = new ArrayVariable("q_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("q_b", s_domBooleans, Q_b);
		Condition c = BeepBeepModule.atBuffer(buffer_c, buffer_b, Q_b, 3, 3);
		assertNotNull(c);
		buffer_c.setValues("a", "b", "c", "a", "b");
		buffer_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testAtBuffer2()
	{
		int Q_b = 5;
		ArrayVariable buffer_c = new ArrayVariable("q_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("q_b", s_domBooleans, Q_b);
		Condition c = BeepBeepModule.atBuffer(buffer_c, buffer_b, Q_b, 3, 4);
		assertNotNull(c);
		buffer_c.setValues("a", "b", "c", "a", "b");
		buffer_b.setValues(true, true, true, true, false);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch1()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 0, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch2()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 1, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch3()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 1, 5);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch4()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4, 8);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch5()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4, 10);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testAtPorch6()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.atPorch(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 1, 1);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testMinTotalPipe1()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.minTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testMinTotalPipe2()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.minTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 8);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testMinTotalPipe3()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.minTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 9);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testMinTotalPipe4()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.minTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 10);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe1()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe2()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 7);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe3()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 8);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe4()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 9);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, true, true, false});
		assertFalse(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe5()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, true, true, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {false, false, false, false, false});
		assertTrue(c.evaluate(a));
	}
	
	@Test
	public void testHasTotalPipe6()
	{
		int Q_b = 5, Q_p = 5;
		ArrayVariable buffer_c = new ArrayVariable("b_c", s_domLetters, Q_b);
		ArrayVariable buffer_b = new ArrayVariable("b_b", s_domBooleans, Q_b);
		ArrayVariable porch_c = new ArrayVariable("p_c", s_domLetters, Q_p);
		ArrayVariable porch_b = new ArrayVariable("p_b", s_domBooleans, Q_p);
		Condition c = BeepBeepModule.hasTotalPipe(porch_c, porch_b, Q_p, buffer_c, buffer_b, Q_b, 4);
		assertNotNull(c);
		Assignment a = new Assignment();
		a.set(buffer_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(buffer_b, new Object[] {true, true, false, false, false});
		a.set(porch_c, new Object[] {"a", "b", "c", "a", "b"});
		a.set(porch_b, new Object[] {true, true, false, false, false});
		assertTrue(c.evaluate(a));
	}
}
