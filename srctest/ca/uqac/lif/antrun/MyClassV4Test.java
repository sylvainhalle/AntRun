/*************************************************************************
    AntRun, a general-purpose Ant build script
    Copyright (C) 2015-2021  Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*************************************************************************/
package ca.uqac.lif.antrun;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A simple main class used to test the build file, using test written with
 * JUnit version 4.
 */
public class MyClassV4Test
{
  
  @Test
  public void test1()
  {
    String s = MyClass.myMethod(1);
    assertEquals("1", s);
  }
}
