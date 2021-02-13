import xerial.sbt.Sonatype._

lazy val testScalastyle = taskKey[Unit]("testScalastyle")

lazy val commonSettings = List(
    scalaVersion := "2.13.1",
    crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.1"),
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "stringdistance",
    version := "1.2.5-SNAPSHOT",
    organization := "com.github.vickumar1981",
    description := "A fuzzy matching string distance library for Scala and Java.",
    sonatypeProjectHosting := Some(GitHubHosting("vickumar1981", "stringdistance", "vickumar@gmail.com")),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    pomIncludeRepository := { _ => false },
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false, includeDependency = false),

    // Add sonatype repository settings
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),

    assemblyJarName := "stringdistance_2.13-" + version.value + ".jar",
    test in assembly := {},

    testScalastyle := scalastyle.in(Test).toTask("").value,
    (test in Test) := ((test in Test) dependsOn testScalastyle).value,

    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0-M4" % Test,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,
    coverageExcludedPackages := "<empty>;.*stringdistance.impl.*Gap",

    coverageEnabled in(Test, compile) := true,
    coverageEnabled in(Compile, compile) := false,
    coverageMinimum := 94,
    coverageFailOnMinimum := true,
    scalastyleFailOnWarning := true
  )

lazy val bench = (project in file("bench"))
  .dependsOn(root)
  .settings(commonSettings: _*)
  .settings(
    name := "stringdistance-benchmarks"
  )
  .enablePlugins(JmhPlugin)
