AntRun: a general-purpose Ant build script
==========================================

AntRun is a template structure for Java projects. Through its comprehensive
Ant build script, it supports automated execution of unit tests, generation
of [Javadoc](http://www.oracle.com/technetwork/articles/java/index-jsp-135444.html)
documentation and code coverage reports (with
[JaCoCo](http://www.eclemma.org/jacoco/)), and download and installation
of JAR dependencies as specified in an external, user-definable XML file.
It also includes a boilerplate `.gitignore` file suitable for an Eclipse or
IntelliJ project.

All this is done in a platform-independent way, so your build scripts
should work on MacOS, Linux and Windows.

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
    tested on version 11 of the JDK, but it is probably safe to use
    any later version.
  - [Ant](http://ant.apache.org) to automate the compilation and build
    process. For Debian-based systems, this corresponds to *two* packages:
    `ant` and `ant-optional`.

2. Download the AntRun template from
   [GitHub](https://github.com/sylvainhalle/AntRun) or clone the repository
   using Git:
   
   git@github.com:sylvainhalle/AntRun.git

3. Override any defaults, and specify any dependencies your project
   requires by editing `config.xml`. In particular, you may want
   to change the name of the Main class.

4. Start writing your code in the `src` folder, and your unit
   tests in `srctest`. Optionally, you can create an Eclipse
   workspace out of the `Source` folder, with the root directory
   as a project. (Eclipse files can also be auto-generated, see
   below.)

5. Use Ant to build your project. To compile the code, generate the
   Javadoc, run the unit tests, generate a test and code coverage report
   and bundle everything in a runnable JAR file, simply type `ant all` on
   the command line.
   
6. If dependencies were specified in step 4 and are not present in the
   system, type `ant download-deps` to automatically download and install
   them before compiling.

Otherwise, use one of the many [tasks](#tasks) that are predefined.

Available tasks                                                    {#tasks}
---------------

In doubt, execute

    $ ant -p

from the project's top folder to get the list of all available targets.

### dist

The default task. Currently applies `jar`.

### compile

Compiles the project; checks and downloads dependencies, if any of them
is not fulfilled.

### compile-tests

Compiles the unit tests. Tests can use either JUnit 4 or JUnit 5. They
are run with JUnit 5 (with the "vintage" engine in the case of tests
written for version 4).

### jar

Compiles the project, generates the Javadoc and creates a runnable JAR,
including the sources and the documentation (and possibly the project's
dependencies, see `download-deps` below).

### test

Performs tests with JUnit. A summary of the execution of the tests is also
printed at the console. The format of this summary depends on the version of
Ant.

### test-legacy

Performs tests with JUnit. Performs tests with jUnit, but without using the
`junitlauncher` task that is supported only in Ant 1.10.6 onwards. This results
in less detailed reports. It is recommended to use only on versions of Ant
prior to 1.10.6.

### report

Generates unit test and code coverage reports (with JaCoCo).
The unit test report (in HTML format) is available in the `tests/junit`
folder (which will be created if it does not exist). The code coverage
report is available in the `tests/coverage` folder.

Alternately, you can call `junit-report` and `jacoco-report` to perform
these tasks individually.

Note that this task requires that tests have first been run, but this must
be done separately. It will fail if it does not find the files generated during
the execution of the tests that are necessary to produce the reports.

### download-deps

Downloads all the JAR dependencies declared in `config.xml`, and required
to correctly build the project. The JAR files are extracted and placed in
the `dep` or the `lib` folder. When compiling (with the `compile` task), the
compiler is instructed to include these JARs in its classpath. Depending on the
setting specified in `config.xml`, these JARs are also bundled in the
output JAR file of the `jar` task.

### clean-reports

Deletes test reports only.

### clean

Deletes compiled files and test reports. The standard task to force a fresh
recompilation of the sources.

### wipe

Like `clean`, but also deletes all JAR dependencies.

### eclipse

Generates `.project` and `.classpath` files for this project. These files
are used by [Eclipse](https://eclipse.org) to setup a project in a workspace.
Select *Import*/*General*/*Existing projects into workspace* and select
the projects folder. The project should show up with all its dependencies
already set.


Continuous integration                                               {#ci}
----------------------

AntRun makes it easy to use [continuous
integration](https://en.wikipedia.org/wiki/Continuous_integration) services
like [Travis CI](https://travis-ci.org) or
[Semaphore](http://semaphoreapp.com). The sequence of commands to
automatically setup the environment, build and test it is (for Linux):

    $ ant
    $ ant test

Notice how all the process is platform-independent.

Declaring dependencies                                              {#deps}
----------------------

Among other configuration settings, dependencies can be declared in the file
`config.xml`. Locate the `<dependencies>` section in that file, and add as
many `<dependency>` entries as required. The structure of such a section is as
follows:

``` xml
<dependency>
      <name>Test Dep</name>
      <classname>ca.uqac.lif.NonExistentClass</classname>
      <files>
        <jar>http://sylvainhalle.github.io/AntRun/placeholders/dummy-jar.jar</jar>
        <zip>http://sylvainhalle.github.io/AntRun/placeholders/dummy-zip.zip</zip>
        <tgz>http://sylvainhalle.github.io/AntRun/placeholders/dummy-tar.tgz</tgz>
      </files>
      <bundle>true</bundle>
</dependency>
```

The parameters are:

- `name`: a human-readable name for the dependency, only used for display
- `classname`: a fully qualified class name that is supposed to be provided
  by the dependency. AntRun checks if this class name is present in the
  classpath; if not, it will download the files specified in the `files`
  section
- `files`: a list of either `jar`, `zip` or `tgz` elements, each containing a
  URL to a JAR file, or an archive of JAR files. AntRun downloads these files
  and places them in either the `dep` or the `lib` folders of the project (both
  are in the classpath). If the URL is a zip or tgz, it also unzips the content
  of the archive.
- `bundle`: when this element has the value `true`, the dependency is copied
  to the `dep` folder; otherwise, it is copied to the `lib` folder. As was
  said, both are in the classpath, but only the JARs in the `dep` folder are
  bundled when creating a JAR file for the project (using the `jar` task).

In Eclipse, it is also possible to depend on another project. This can
be specified using the `project` element, as follows:

``` xml
<project>Name of the project</project>
```

Cross-compiling                                                 {#xcompile}
---------------

The `.class` files are marked with the major version number of the compiler
that created them; hence a file compiled with JDK 1.11 will contain this
version number in its metadata. A JRE 1.8 will refuse to run them,
regardless of whether they were built from 1.8-compliant code.
*Cross-compiling* is necessary if one wants to make a project compatible
with a version of Java earlier than the one used to compile it. 

By default, AntRun compiles your project using the default JDK installed on
your computer. However, you can compile files that are compatible with
a specific version of Java by setting the `targetjdk` parameter to the
a version of Java (e.g. 8 for Java 8) in `config.xml`.

Projects that use AntRun                                        {#projects}
------------------------

Virtually every Java project developed at [LIF](https://liflab.github.io) uses
an AntRun template project. This includes:

- [Azrael](https://github.com/sylvainhalle/Azrael), a generic serialization
  library
- [BeepBeep 3](https://liflab.github.io/beepbeep-3), an event stream
  processing engine, and most of its
  [palettes](https://github.com/liflab/beepbeep-3-palettes)
- [Bullwinkle](https://github.com/sylvainhalle/Bullwinkle), a runtime BNF
  parser
- [Jerrydog](https://github.com/sylvainhalle/Jerrydog), a lightweight web
  server
- [LabPal](https://liflab.github.io/labpal), a framework for running
  computer experiments
- [Petit Poucet](https://github.com/liflab/petitpoucet), a generic
  explainability library
- [Synthia](https://github.com/liflab/synthia), a modular data structure
  generator
- [TeXtidote](https://github.com/sylvainhalle/textidote), a spelling and
  grammar checker for LaTeX documents

...and many more.

About the author                                                   {#about}
----------------

AntRun was written by [Sylvain Hallé](https://leduotang.ca/sylvain),
Full Professor at [Université du Québec à
Chicoutimi](https://www.uqac.ca/), Canada.
