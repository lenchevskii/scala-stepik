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

// def printNumbersResult(fArgs: Array[String]): Unit = {
//   @tailrec
//   def loop(x: Int, y: Int, n: Int): Unit =
//     if (x == y) println("")
//     else println(" ")

//   loop(fArgs(0), fArgs(1), fArgs(2))
// }

object Recursion extends App {

  // println(powerOfTwo(1458))

}
