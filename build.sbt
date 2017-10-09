val currentScalaVersion = "2.11.11"

name in ThisBuild := "akka-http-webjars"

organization in ThisBuild := "org.mdedetrich"

scalaVersion in ThisBuild := currentScalaVersion

crossScalaVersions in ThisBuild := Seq(currentScalaVersion, "2.12.3")

libraryDependencies += "org.webjars" % "webjars-locator" % "0.32"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.10"

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
pomIncludeRepository := (_ => false)
