class NoSuchElementExceptionG extends Exception {}

abstract class LogListG[+A] {

  def add[B >: A](msg: B): LogListG[B]

  def all(): String

  def isEmptyG(): Boolean

  def last(): A

  def previous(): LogListG[A]

}

object EmptyG extends LogListG[Nothing] {

  override def all(): String = ""

  override def isEmptyG(): Boolean = true

  override def last(): Nothing = throw new NoSuchElementExceptionG

  override def previous(): LogListG[Nothing] = throw new NoSuchElementExceptionG

  override def add[B >: Nothing](msg: B): LogListG[B] = new LogG(msg, EmptyG)

}

class LogG[+A](head: A, tail: LogListG[A]) extends LogListG[A] {

  override def add[B >: A](msg: B): LogListG[B] = new LogG(msg, this)

  override def isEmptyG(): Boolean = false

  override def all(): String =
    if (this.tail.isEmptyG()) this.head.toString()
    else s"$head ${this.previous().all()}"

  override def last(): A = this.head

  override def previous(): LogListG[A] = this.tail

}

object GenericList extends App {
  val l = LogG("1stLog", LogG("2ndLog", LogG("3rdLog", EmptyG)))
  val intLogs: LogListG[Int] = EmptyG

  println(l.previous().add("4thLog").last())
}
