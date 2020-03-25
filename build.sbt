import xerial.sbt.Sonatype._

name := "stringdistance"
version := "1.2.0-SNAPSHOT"
scalaVersion := "2.13.1"
organization := "com.github.vickumar1981"
description := "A fuzzy matching string distance library for Scala and Java."
sonatypeProjectHosting := Some(GitHubHosting("vickumar1981", "stringdistance", "vickumar@gmail.com"))
publishMavenStyle := true
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
pomIncludeRepository := { _ => false }
publishArtifact in Test := false
crossScalaVersions := Seq("2.11.11", "2.12.7", "2.13.1")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false, includeDependency = false)

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

assemblyJarName := "stringdistance_2.13-" + version.value + ".jar"
test in assembly := {}

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0-M4" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test

lazy val testScalastyle = taskKey[Unit]("testScalastyle")
testScalastyle := scalastyle.in(Test).toTask("").value
(test in Test) := ((test in Test) dependsOn testScalastyle).value

coverageExcludedPackages := "<empty>;.*stringdistance.interfaces.sound.*;.*stringdistance.impl.*Gap"

coverageEnabled in(Test, compile) := true
coverageEnabled in(Compile, compile) := false
coverageMinimum := 99
coverageFailOnMinimum := true
scalastyleFailOnWarning := true