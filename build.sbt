name := "stringdistance"
version := "1.0.0"
scalaVersion := "2.12.6"
organization := "org.vickumar"
publishMavenStyle := true

publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")

assemblyJarName := "stringdistance-" + version.value + ".jar"
libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"