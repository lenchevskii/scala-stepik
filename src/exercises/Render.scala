import exercises.{config, Connection}
import scala.util.Try

val url = "http://localhost"

def render(page: String): Unit = ???

val forHtmlRendering: Option[String] = for {
  host <- config.map(_.getOrElse("host", ""))
  // host <- config.get("host")
  port <- config.map(_.getOrElse("port", ""))
  // port <- config.get("port")
  connection <- Try(new Connection(host, port)).toOption
} yield connection.connect.get

object Render extends App {
  forHtmlRendering.foreach(render)
}
