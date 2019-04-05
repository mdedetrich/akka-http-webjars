val currentScalaVersion = "2.11.11"

name in ThisBuild := "akka-http-webjars"

organization in ThisBuild := "org.mdedetrich"

scalaVersion in ThisBuild := currentScalaVersion

val akkaVersion = "2.5.21"

crossScalaVersions in ThisBuild := Seq(currentScalaVersion, "2.12.8")

libraryDependencies ++= Seq(
  "org.webjars" % "webjars-locator" % "0.32",
  "com.typesafe.akka" %% "akka-http" % "10.1.8",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

val flagsFor11 = Seq(
  "-Xlint:_",
  "-Yconst-opt",
  "-Ywarn-infer-any",
  "-Yclosure-elim",
  "-Ydead-code",
  "-Xsource:2.12" // required to build case class construction
)

val flagsFor12 = Seq(
  "-Xlint:_",
  "-Ywarn-infer-any",
  "-opt-inline-from:<sources>"
)

homepage := Some(url("https://github.com/mdedetrich/webmodels"))
scmInfo := Some(
  ScmInfo(url("https://github.com/mdedetrich/webmodels"),
          "git@github.com:mdedetrich/webmodels.git"))
developers := List(
  Developer("atry",
    "Yang Bo",
    "pop.atry@gmail.com",
    url("https://www.zhihu.com/people/atry/activities")),
  Developer("mdedetrich",
            "Matthew de Detrich",
            "mdedetrich@gmail.com",
            url("https://github.com/mdedetrich"))
)
licenses += ("Apache 2", url(
  "https://opensource.org/licenses/Apache-2.0"))

publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
publishArtifact in Test := false
pomIncludeRepository := (_ => false)

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, n)) if n >= 12 =>
      flagsFor12
    case Some((2, n)) if n == 11 =>
      flagsFor11
  }
}
