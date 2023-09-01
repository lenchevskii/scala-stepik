class Logger(val msgNum: Int = 0) {
  def print = println(msgNum)

  def info(): Logger = {
    println("INFO New Message")
    new Logger(msgNum + 1)
  }

  def info(n: Int): Logger =
    if (n <= 0) this
    else info().info(n - 1)
}

object LogSystem extends App {
  val logger = Logger(10)

  val newLogger = logger.info(3)

  newLogger.info().print
}
