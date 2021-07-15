[![Build Status](https://img.shields.io/github/workflow/status/mdedetrich/akka-http-webjars/Continuous%20Integration.svg)](https://github.com/mdedetrich/akka-http-webjars/actions)
[![Latest version](https://index.scala-lang.org/mdedetrich/akka-http-webjars/akka-http-webjars/latest.svg?color=orange)](https://index.scala-lang.org/mdedetrich/akka-http-webjars)
[![Apache License](https://img.shields.io/badge/license-APACHE_2-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

# akka-http-webjars
Allows you to serve static assets from [WebJars](https://www.webjars.org/) with [akka-http](https://doc.akka.io/docs/akka-http/current/index.html).

## Usage

Published for Scala 2.12 and Scala 2.13

```sbt
libraryDependencies ++= Seq(
  "org.mdedetrich" %% "akka-http-webjars" % "0.4.0"
)
```

Then you simply need to import the `org.mdedetrich.akka.http.WebJarsSupport` object and add a route, i.e.

```scala
import org.mdedetrich.akka.http.WebJarsSupport._
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class Routes {

  private def webJarAssets = pathPrefix("webjars") {
    webJars
  }
  
  val routes: Route = webJarAssets

}
```

Then you can simply refer to a webjar like so

```html
<head>
  <script src="webjars/es5-shim.min.js">
</head>
```
