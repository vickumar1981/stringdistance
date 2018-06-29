name := "stringdistance"
version := "1.0.0"
scalaVersion := "2.12.6"
organization := "com.github.vickumar1981"
homepage := Some(url("https://github.com/vickumar1981/stringdistance"))
scmInfo := Some(ScmInfo(url("https://github.com/vickumar1981/stringdistance"),
  "git@github.com:vickumar/stringdistance.git"))
developers := List(Developer("vickumar1981",
  "Vic Kumar",
  "vickumar@gmail.com",
  url("https://github.com/vickumar1981")))
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true

artifact in (Compile, assembly) := {
  val art = (artifact in (Compile, assembly)).value
  art.withClassifier(Some(version.value))
}

addArtifact(artifact in (Compile, assembly), assembly)

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

assemblyJarName := "stringdistance_2.12-" + version.value + ".jar"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"