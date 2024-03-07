file://<WORKSPACE>/build.sbt
### file%3A%2F%2F%2Fhome%2Fyorch%2Fdev%2Fscala-fundamentals%2Fbuild.sbt:74: error: illegal start of simple expression
lazy val root = (project in file("."))
^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.12.18
Classpath:
<WORKSPACE>/project/.bloop/scala-fundamentals-build/bloop-bsp-clients-classes/classes-Metals-gpgXtDKESumwdaI6xdQX2Q== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/sbt/1.9.8/sbt-1.9.8.jar [exists ], <HOME>/.sbt/boot/scala-2.12.18/lib/scala-library.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/ch/epfl/scala/sbt-bloop_2.12_1.0/1.5.15/sbt-bloop_2.12_1.0-1.5.15.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/main_2.12/1.9.8/main_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/io_2.12/1.9.8/io_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/ch/epfl/scala/bloop-config_2.12/1.5.5/bloop-config_2.12-1.5.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/logic_2.12/1.9.8/logic_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/actions_2.12/1.9.8/actions_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/main-settings_2.12/1.9.8/main-settings_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/run_2.12/1.9.8/run_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/command_2.12/1.9.8/command_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/collections_2.12/1.9.8/collections_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/scripted-plugin_2.12/1.9.8/scripted-plugin_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-lm-integration_2.12/1.9.8/zinc-lm-integration_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-logging_2.12/1.9.8/util-logging_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-xml_2.12/2.2.0/scala-xml_2.12-2.2.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/launcher-interface/1.4.2/launcher-interface-1.4.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/github/ben-manes/caffeine/caffeine/2.8.5/caffeine-2.8.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/io/get-coursier/lm-coursier-shaded_2.12/2.1.2/lm-coursier-shaded_2.12-2.1.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.17.1/log4j-api-2.17.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.17.1/log4j-core-2.17.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/apache/logging/log4j/log4j-slf4j-impl/2.17.1/log4j-slf4j-impl-2.17.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-core_2.12/1.9.3/librarymanagement-core_2.12-1.9.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/librarymanagement-ivy_2.12/1.9.3/librarymanagement-ivy_2.12-1.9.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/compiler-interface/1.9.5/compiler-interface-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-compile_2.12/1.9.5/zinc-compile_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/swoval/file-tree-views/2.1.12/file-tree-views-2.1.12.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/net/java/dev/jna/jna/5.13.0/jna-5.13.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/net/java/dev/jna/jna-platform/5.13.0/jna-platform-5.13.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/github/plokhotnyuk/jsoniter-scala/jsoniter-scala-core_2.12/2.4.0/jsoniter-scala-core_2.12-2.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-relation_2.12/1.9.8/util-relation_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/completion_2.12/1.9.8/completion_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/task-system_2.12/1.9.8/task-system_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/tasks_2.12/1.9.8/tasks_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/testing_2.12/1.9.8/testing_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-tracking_2.12/1.9.8/util-tracking_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-scalajson_2.12/0.9.1/sjson-new-scalajson_2.12-0.9.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-terminal/3.19.0/jline-terminal-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classpath_2.12/1.9.5/zinc-classpath_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-apiinfo_2.12/1.9.5/zinc-apiinfo_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc_2.12/1.9.5/zinc_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/core-macros_2.12/1.9.8/core-macros_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-cache_2.12/1.9.8/util-cache_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-control_2.12/1.9.8/util-control_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/protocol_2.12/1.9.8/protocol_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-core_2.12/0.9.1/sjson-new-core_2.12-0.9.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/template-resolver/0.1/template-resolver-0.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-position_2.12/1.9.8/util-position_2.12-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-compile-core_2.12/1.9.5/zinc-compile-core_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/util-interface/1.9.8/util-interface-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/jline/jline/2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493/jline-2.14.7-sbt-a1b0ffbb8f64bb820f4f84a0c07a0c0964507493.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-terminal-jna/3.19.0/jline-terminal-jna-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-terminal-jansi/3.19.0/jline-terminal-jansi-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/lmax/disruptor/3.4.2/disruptor-3.4.2.jar [exists ], <HOME>/.sbt/boot/scala-2.12.18/lib/scala-reflect.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/checkerframework/checker-qual/3.4.1/checker-qual-3.4.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/google/errorprone/error_prone_annotations/2.4.0/error_prone_annotations-2.4.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-collection-compat_2.12/2.10.0/scala-collection-compat_2.12-2.10.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar [exists ], <HOME>/.sbt/boot/scala-2.12.18/lib/scala-compiler.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/jcraft/jsch/0.1.54/jsch-0.1.54.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-apache-http_2.12/0.7.0/gigahorse-apache-http_2.12-0.7.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/ivy/ivy/2.3.0-sbt-396a783bba347016e7fe30dacc60d355be607fe2/ivy-2.3.0-sbt-396a783bba347016e7fe30dacc60d355be607fe2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-reader/3.19.0/jline-reader-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-builtins/3.19.0/jline-builtins-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/test-agent/1.9.8/test-agent-1.9.8.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/shaded-jawn-parser_2.12/0.9.1/shaded-jawn-parser_2.12-0.9.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/shaded-scalajson_2.12/1.0.0-M4/shaded-scalajson_2.12-1.0.0-M4.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/compiler-bridge_2.12/1.9.5/compiler-bridge_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-classfile_2.12/1.9.5/zinc-classfile_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-core_2.12/1.9.5/zinc-core_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-persist_2.12/1.9.5/zinc-persist_2.12-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/sjson-new-murmurhash_2.12/0.9.1/sjson-new-murmurhash_2.12-0.9.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/ipcsocket/ipcsocket/1.6.2/ipcsocket-1.6.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.12/1.1.2/scala-parser-combinators_2.12-1.1.2.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/net/openhft/zero-allocation-hashing/0.10.1/zero-allocation-hashing-0.10.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/fusesource/jansi/jansi/2.1.0/jansi-2.1.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/gigahorse-core_2.12/0.7.0/gigahorse-core_2.12-0.7.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/eed3si9n/shaded-apache-httpasyncclient/0.7.0/shaded-apache-httpasyncclient-0.7.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/jline/jline-style/3.19.0/jline-style-3.19.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/zinc-persist-core-assembly/1.9.5/zinc-persist-core-assembly-1.9.5.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-sbt/sbinary_2.12/0.5.1/sbinary_2.12-0.5.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/typesafe/ssl-config-core_2.12/0.6.1/ssl-config-core_2.12-0.6.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/reactivestreams/reactive-streams/1.0.3/reactive-streams-1.0.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/typesafe/config/1.4.2/config-1.4.2.jar [exists ]
Options:
-deprecation -Wconf:cat=unused-nowarn:s -Wconf:cat=unused-nowarn:s -Xsource:3 -Yrangepos -Xplugin-require:semanticdb


action parameters:
uri: file://<WORKSPACE>/build.sbt
text:
```scala
import _root_.scala.xml.{TopScope=>$scope}
import _root_.sbt._
import _root_.sbt.Keys._
import _root_.sbt.nio.Keys._
import _root_.sbt.ScriptedPlugin.autoImport._, _root_.sbt.plugins.JUnitXmlReportPlugin.autoImport._, _root_.sbt.plugins.MiniDependencyTreePlugin.autoImport._, _root_.bloop.integrations.sbt.BloopPlugin.autoImport._
import _root_.sbt.plugins.IvyPlugin, _root_.sbt.plugins.JvmPlugin, _root_.sbt.plugins.CorePlugin, _root_.sbt.ScriptedPlugin, _root_.sbt.plugins.SbtPlugin, _root_.sbt.plugins.SemanticdbPlugin, _root_.sbt.plugins.JUnitXmlReportPlugin, _root_.sbt.plugins.Giter8TemplatePlugin, _root_.sbt.plugins.MiniDependencyTreePlugin, _root_.bloop.integrations.sbt.BloopPlugin
// The simplest possible sbt build file is just one line:

scalaVersion := "2.13.12"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.12"

// It's possible to define many kinds of settings, such as:

name := "hello-world"
organization := "ch.epfl.scala"
version := "1.0"

// Note, it's not required for you to define these three settings. These are
// mostly only necessary if you intend to publish your library's binaries on a
// place like Sonatype.

// Want to use a published library in your project?
// You can define other libraries as dependencies in your build like this:

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"

// Here, `libraryDependencies` is a set of dependencies, and by using `+=`,
// we're adding the scala-parser-combinators dependency to the set of dependencies
// that sbt will go and fetch when it starts up.
// Now, in any Scala file, you can import classes, objects, etc., from
// scala-parser-combinators with a regular import.

// TIP: To find the "dependency" that you need to add to the
// `libraryDependencies` set, which in the above example looks like this:

// "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"

// You can use Scaladex, an index of all known published Scala libraries. There,
// after you find the library you want, you can just copy/paste the dependency
// information that you need into your build file. For example, on the
// scala/scala-parser-combinators Scaladex page,
// https://index.scala-lang.org/scala/scala-parser-combinators, you can copy/paste
// the sbt dependency from the sbt box on the right-hand side of the screen.

// IMPORTANT NOTE: while build files look _kind of_ like regular Scala, it's
// important to note that syntax in *.sbt files doesn't always behave like
// regular Scala. For example, notice in this build file that it's not required
// to put our settings into an enclosing object or class. Always remember that
// sbt is a bit different, semantically, than vanilla Scala.

// ============================================================================

// Most moderately interesting Scala projects don't make use of the very simple
// build file style (called "bare style") used in this build.sbt file. Most
// intermediate Scala projects make use of so-called "multi-project" builds. A
// multi-project build makes it possible to have different folders which sbt can
// be configured differently for. That is, you may wish to have different
// dependencies or different testing frameworks defined for different parts of
// your codebase. Multi-project builds make this possible.

// Here's a quick glimpse of what a multi-project build looks like for this
// build, with only one "subproject" defined, called `root`:

lazy val root = (project in file("."))
  .settings(
    // Otras configuraciones
lazy val root = (project in file("."))
 .settings(
    // Otras configuraciones
    sourceDirectories in Compile += baseDirectory.value / "src/playground",
    sourceDirectories in Compile += baseDirectory.value / "lectures/part1basics"
 )
  )

// To learn more about multi-project builds, head over to the official sbt
// documentation at http://www.scala-sbt.org/documentation.html

```



#### Error stacktrace:

```
scala.meta.internal.parsers.ScalametaParser.simpleExpr0(ScalametaParser.scala:2270)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr(ScalametaParser.scala:2223)
	scala.meta.internal.parsers.ScalametaParser.prefixExpr(ScalametaParser.scala:2206)
	scala.meta.internal.parsers.ScalametaParser.postfixExpr(ScalametaParser.scala:2081)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$expr$2(ScalametaParser.scala:1676)
	scala.meta.internal.parsers.ScalametaParser.atPosOpt(ScalametaParser.scala:322)
	scala.meta.internal.parsers.ScalametaParser.autoPosOpt(ScalametaParser.scala:366)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1581)
	scala.meta.internal.parsers.ScalametaParser.argumentExpr(ScalametaParser.scala:2434)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$argumentExprsInParens$1(ScalametaParser.scala:2461)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1$adapted(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.iter$1(ScalametaParser.scala:645)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1(ScalametaParser.scala:651)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1$adapted(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$listBy(ScalametaParser.scala:567)
	scala.meta.internal.parsers.ScalametaParser.tokenSeparated(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.commaSeparatedWithIndex(ScalametaParser.scala:658)
	scala.meta.internal.parsers.ScalametaParser.commaSeparated(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.argumentExprsInParens(ScalametaParser.scala:2461)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$getArgClause$2(ScalametaParser.scala:2447)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$inParensAfterOpenOr(ScalametaParser.scala:253)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$inParensOnOpenOr(ScalametaParser.scala:244)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$getArgClause$1(ScalametaParser.scala:2448)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$getArgClause(ScalametaParser.scala:2437)
	scala.meta.internal.parsers.ScalametaParser.simpleExprRest(ScalametaParser.scala:2344)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$simpleExpr0$3(ScalametaParser.scala:2273)
	scala.util.Success.$anonfun$map$1(Try.scala:255)
	scala.util.Success.map(Try.scala:213)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr0(ScalametaParser.scala:2273)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr(ScalametaParser.scala:2223)
	scala.meta.internal.parsers.ScalametaParser.prefixExpr(ScalametaParser.scala:2206)
	scala.meta.internal.parsers.ScalametaParser.postfixExpr(ScalametaParser.scala:2081)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$expr$2(ScalametaParser.scala:1676)
	scala.meta.internal.parsers.ScalametaParser.atPosOpt(ScalametaParser.scala:322)
	scala.meta.internal.parsers.ScalametaParser.autoPosOpt(ScalametaParser.scala:366)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1581)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1480)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$patDefOrDcl$1(ScalametaParser.scala:3589)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:368)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:373)
	scala.meta.internal.parsers.ScalametaParser.patDefOrDcl(ScalametaParser.scala:3576)
	scala.meta.internal.parsers.ScalametaParser.defOrDclOrSecondaryCtor(ScalametaParser.scala:3538)
	scala.meta.internal.parsers.ScalametaParser.nonLocalDefOrDcl(ScalametaParser.scala:3523)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4382)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4377)
	scala.PartialFunction.$anonfun$runWith$1$adapted(PartialFunction.scala:145)
	scala.meta.internal.parsers.ScalametaParser.statSeqBuf(ScalametaParser.scala:4440)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$13(ScalametaParser.scala:4674)
	scala.Option.getOrElse(Option.scala:189)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$1(ScalametaParser.scala:4674)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.batchSource(ScalametaParser.scala:4630)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$source$1(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.source(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.entrypointSource(ScalametaParser.scala:4628)
	scala.meta.internal.parsers.ScalametaParser.parseSourceImpl(ScalametaParser.scala:135)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$parseSource$1(ScalametaParser.scala:132)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:59)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:54)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:132)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:29)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:36)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

file%3A%2F%2F%2Fhome%2Fyorch%2Fdev%2Fscala-fundamentals%2Fbuild.sbt:74: error: illegal start of simple expression
lazy val root = (project in file("."))
^