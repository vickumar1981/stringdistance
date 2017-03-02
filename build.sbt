name := "stringdistance"
version := "1.0.0"
scalaVersion := "2.11.6"
organization := "org.vickumar"
publishMavenStyle := true

publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/content/repositories/snapshots")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"