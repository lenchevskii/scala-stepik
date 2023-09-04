package lectures.week3fp

def countNumbers(str: String): Map[Char, Int] =
  str.foldLeft(Map[Char, Int]().withDefaultValue(0))((acc, letter) =>
    if (letter != '-') acc + (letter -> (1 + acc(letter)))
    else acc
  )

object Summary extends App {
  println(countNumbers("9-876-543-21-09"))
}
