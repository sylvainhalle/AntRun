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

/**
 * A simple main class used to test the build file
 */
public class MyClass
{
  /**
   * Returns a string from a given integer
   * @param x The integer
   */
  public static String myMethod(int x)
  {
    @SuppressWarnings("deprecation")
		Integer i = new Integer(x);
    return i.toString();
  }
}
