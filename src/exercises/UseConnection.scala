val config: Option[Map[String, String]] = Some(
  Map("host" -> "localhost", "port" -> "8080")
)

class Connection(host: String, port: String) {
  def connect: Option[String] = ???
}

class UseConnection extends App {
  val forConnectionStatus: Option[String] = for {
    host <- config.map(_.getOrElse("host", ""))
    port <- config.map(_.getOrElse("port", ""))
    connection <- Some(new Connection(host, port))
  } yield connection.connect.getOrElse("")

  forConnectionStatus.foreach(println)
}
