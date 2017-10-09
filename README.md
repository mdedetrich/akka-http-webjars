# akka-http-webjars
Allows you to serve static assets from [WebJars](https://www.webjars.org/) with [akka-http](link).

## Usage

Published for Scala 2.11 and Scala 2.12

```sbt
libraryDependencies ++= Seq(
  "org.mdedetrich" %% "akka-http-webjars" % "0.1.0"
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
