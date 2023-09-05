package lectures.week3fp

def countNumbers(str: String): List[(Char, Int)] =
  str
    .toLowerCase
    .foldLeft(Map[Char, Int]().withDefaultValue(0))((acc, letter) =>
      acc + (letter -> (1 + acc(letter)))
    )
    .toList
    .sortBy { case (char, num) => num }

// def normalize(v1Splitted: List[String], v2Splitted: List[String]): (List[String], List[String]) =
//   if (v1Splitted.length >= v2Splitted.length)

def compare(v1: String, v2: String): Int = {
  val v1Splitted = v1.split(".")
  val v2Splitted = v2.split(".")

  (v1Splitted, v2Splitted) match
    case (v1, v2) => 1
}

def duplicate[A](someList: List[A], numDups: Int): List[A] = {
  someList.flatMap(elem => List.fill(numDups)(elem))
}

object Summary extends App {
  println(countNumbers("9-876-543-21-09"))
}
