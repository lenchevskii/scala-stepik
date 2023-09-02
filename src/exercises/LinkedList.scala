class NoSuchElementException extends Exception {}

abstract class LogList {

  def add(msg: String): LogList

  def all(): String

  def isEmpty(): Boolean

  def last(): String

  def previous(): LogList

}

object Empty extends LogList {

  override def all(): String = ""

  override def isEmpty(): Boolean = true

  override def last(): String = throw new NoSuchElementException

  override def previous(): LogList = throw new NoSuchElementException

  override def add(msg: String): LogList = new Log(msg, Empty)

}

class Log(head: String, tail: LogList) extends LogList {

  override def add(msg: String): LogList = new Log(msg, this)

  override def isEmpty(): Boolean = false

  override def all(): String =
    if (this.tail.isEmpty()) head else s"$head ${this.previous().all()}"

  override def last(): String = this.head

  override def previous(): LogList = this.tail

}

object LinkedList extends App {
  val l = Log("1stLog", Log("2ndLog", Log("3rdLog", Empty)))

  println(l.previous().add("4thLog").last())
}
