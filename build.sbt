val currentScalaVersion = "2.12.14"

name                           := "akka-http-webjars"
ThisBuild / organization       := "org.mdedetrich"
ThisBuild / scalaVersion       := currentScalaVersion
ThisBuild / crossScalaVersions := Seq(currentScalaVersion, "2.13.6")

val akkaVersion = "2.6.15"

libraryDependencies ++= Seq(
  "org.webjars"        % "webjars-locator" % "0.41",
  "com.typesafe.akka" %% "akka-http"       % "10.2.4"    % Provided,
  "com.typesafe.akka" %% "akka-stream"     % akkaVersion % Provided
)

val flagsFor12 = Seq(
  "-Xlint:_",
  "-Ywarn-infer-any",
  "-opt-inline-from:<sources>",
  "-opt:l:method"
)

val flagsFor13 = Seq(
  "-Xlint:_",
  "-opt-inline-from:<sources>",
  "-opt:l:method"
)

homepage := Some(url("https://github.com/mdedetrich/akka-http-webjars"))
scmInfo := Some(
  ScmInfo(url("https://github.com/mdedetrich/akka-http-webjars"), "git@github.com:mdedetrich/akka-http-webjars.git")
)
developers := List(
  Developer("atry", "Yang Bo", "pop.atry@gmail.com", url("https://www.zhihu.com/people/atry/activities")),
  Developer("mdedetrich", "Matthew de Detrich", "mdedetrich@gmail.com", url("https://github.com/mdedetrich"))
)
licenses += ("Apache 2", url("https://opensource.org/licenses/Apache-2.0"))

publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
Test / publishArtifact := false
pomIncludeRepository   := (_ => false)

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, n)) if n >= 13 =>
      flagsFor13
    case Some((2, n)) if n == 12 =>
      flagsFor12
  }
}
