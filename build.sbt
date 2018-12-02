import xerial.sbt.Sonatype._

name := "stringdistance"
version := "1.0.8-SNAPSHOT"
scalaVersion := "2.12.7"
organization := "com.github.vickumar1981"
description := "A fuzzy matching string distance library for Scala and Java."
sonatypeProjectHosting := Some(GitHubHosting("vickumar1981", "stringdistance", "vickumar@gmail.com"))
publishMavenStyle := true
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
pomIncludeRepository := { _ => false }
publishArtifact in Test := false
crossScalaVersions := Seq("2.11.11", "2.12.7")

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

assemblyJarName := "stringdistance_2.12-" + version.value + ".jar"
test in assembly := {}

artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.withClassifier(Some(version.value))
}
addArtifact(artifact in (Compile, assembly), assembly)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test

lazy val testScalastyle = taskKey[Unit]("testScalastyle")
testScalastyle := scalastyle.in(Test).toTask("").value
(test in Test) := ((test in Test) dependsOn testScalastyle).value

coverageExcludedPackages := "<empty>;.*stringdistance.interfaces.sound.*;.*stringdistance.impl.*Gap"

coverageEnabled in(Test, compile) := true
coverageEnabled in(Compile, compile) := false
coverageMinimum := 100
coverageFailOnMinimum := true
scalastyleFailOnWarning := true