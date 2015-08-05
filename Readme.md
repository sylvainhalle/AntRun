AntRun: a general-purpose Ant build script
==========================================

[![Build Status](https://semaphoreci.com/api/v1/projects/5eab613c-29af-43c0-8961-0170588f6368/466366/badge.svg)](https://semaphoreci.com/sylvainhalle/antrun)

AntRun is a template structure for Java projects. Through its comprehensive
Ant build script, it supports automated execution of unit tests, generation
of [Javadoc](http://www.oracle.com/technetwork/articles/java/index-jsp-135444.html)
documentation and code coverage reports (with
[JaCoCo](http://www.eclemma.org/jacoco/)), and download and installation
of JAR dependencies as specified in an external, user-definable XML file.
It also includes a boilerplate `.gitignore` file suitable for an Eclipse
project.

All this is done in a platform-independent way, so your build scripts
should work on both MacOS, Linux and Windows.

Table of Contents                                                    {#toc}
-----------------

- [Quick start guide](#quickstart)
- [Available tasks](#tasks)
- [Continuous integration](#ci)
- [Cross-compiling](#xcompile)
- [About the author](#about)

Quick start guide                                             {#quickstart}
-----------------

1. First make sure you have the following installed:

  - The Java Development Kit (JDK) to compile. AntRun was developed and
    tested on version 7 of the JDK, but it is probably safe to use any
    later version.
  - [Ant](http://ant.apache.org) to automate the compilation and build
    process

2. Download the AntRun template from
   [GitHub](https://github.com/sylvainhalle/AntRun) or clone the repository
   using Git:
   
   git@github.com:sylvainhalle/AntRun.git

3. Override any defaults, and specify any dependencies your project
   requires by editing `config.xml`. In particular, you may want
   to change the name of the Main class.

4. Start writing your code in the `Source/Core` folder, and your unit
   tests in `Source/CoreTest`. Optionally, you can create an Eclipse
   workspace out of the `Source` folder, with `Core` and `CoreTest` as
   two projects within this workspace.

5. Use Ant to build your project. To compile the code, generate the
   Javadoc, run the unit tests, generate a test and code coverage report
   and bundle everything in a runnable JAR file, simply type `ant` (without
   any arguments) on the command line.
   
6. If dependencies were specified in step 4 and are not present in the
   system, type `ant download-deps`, followed by `ant install-deps` to
   automatically download and install them before compiling. The latter
   command might require to be run as administrator --the way to do this
   varies according to your operating system (see below).

Otherwise, use one of the many [tasks](#tasks) that are predefined.

Available tasks                                                    {#tasks}
---------------

This document is incomplete. Execute

    $ ant -p

from the project's top folder to get the list of all available targets.

### dist

The default task. Currently applies `jar`.

### compile

Compiles the project.

### compile-tests

Compiles the unit tests.

### jar

Compiles the project, generates the Javadoc and creates a runnable JAR,
including the sources and the documentation.

### test

Performs tests with jUnit and generates code coverage report with JaCoCo.
The unit test report (in HTML format) is available in the `test/junit`
folder (which will be created if it does not exist). The code coverage
report is available in the `test/coverage` folder.

Continuous integration                                               {#ci}
----------------------

AntRun makes it easy to use [continuous
integration](https://en.wikipedia.org/wiki/Continuous_integration) services
like [Travis CI](https://travis-ci.org) or
[Semaphore](http://semaphoreapp.com). The sequence of commands to
automatically setup the environment, build and test it is (for Linux):

    $ ant download-deps
    $ sudo ant install-deps
    $ ant dist test

The second command must be run as administrator, as it copies the required
dependencies into a system folder that generally requires that access. For
Windows systems, running as administrator is done with the
[`runas` command](https://technet.microsoft.com/en-us/library/cc771525.aspx#BKMK_examples).

Notice how, apart from the call to `sudo`, all the process is
platform-independent.

Cross-compiling                                                 {#xcompile}
---------------

By default, AntRun compiles your project using the default JDK installed on
your computer. However, you can compile files that are compatible with
Java **6** and upwards by defining the environment variable
`JAVA6_BOOTCLASSES`. This variable should contain the location of all the basic
classes of version 6 of the JDK. You can automatically define the contents of
this variable through a script; for example using Bash:

> export JAVA5_BOOTCLASSES=""
> for i in /usr/lib/jvm/java/jre/lib/*.jar; do 
>     export JAVA5_BOOTCLASSES=$JAVA5_BOOTCLASSES:$i
> done

Replace `/usr/lib...` by the location of the JDK on your system.

About the author                                                   {#about}
----------------

AntRun was written by [Sylvain Hallé](http://leduotang.ca/sylvain),
associate professor at [Université du Québec à
Chicoutimi](http://www.uqac.ca/), Canada.
