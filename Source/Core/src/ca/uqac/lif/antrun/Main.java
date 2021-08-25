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

import ca.uqac.lif.antrun.dep.jar.*;
import ca.uqac.lif.antrun.dep.zip.*;

/**
 * A simple main class used to test the build file
 */
public class Main
{
  /**
   * The main method for the main class
   * @param args Any command-line arguments
   */
  @SuppressWarnings("unused")
	public static void main(String[] args)
  {
    // Use another class to ensure the compilation worked
    MyClass mc = new MyClass();
    MyJarDependency mjd = new MyJarDependency();
    MyZipDependency mzd = new MyZipDependency();
    System.out.println("This is the main class successfully executing!");
    System.exit(0);
  }
}
