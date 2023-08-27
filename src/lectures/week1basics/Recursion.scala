package lectures.week1basics

import scala.annotation.tailrec

def factorialWithTailRecursion(n: Int): Int = {
  @tailrec
  def loop(x: Int, accumulator: Int = 1): Int = {
    if (x <= 1) accumulator
    else loop(x - 1, x * accumulator)
  }

  loop(n)
}

def powerOfTwo(power: BigInt): BigInt = {
  @tailrec
  def loop(x: BigInt, accumulator: BigInt = 1): BigInt = {
    if (x < 1) 1
    else if (x == 1) 2 * accumulator
    else loop(x - 1, 2 * accumulator)
  }

  loop(power)
}

def printNumbersResult(x: Int, y: Int, n: Int): Unit = {
  @tailrec
  def loop(x: Int, y: Int, n: Int): Unit =
    if (n == 1) println(s"${((x + y).toString() + " ") * (x + y).toString().length}is the result")
    else loop(x + y, y, n - 1)

  loop(x, y, n)
}

object Recursion extends App {
  val input = "I like Scala"

  val res = input.split("\\s+").reverse.mkString(" ")

  println(res)
}
