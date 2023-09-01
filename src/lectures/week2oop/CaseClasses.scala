package lectures.week2oop

case class ScalaCourse(title: String, instructor: String)

object ScalaCourse {
  def apply(instructor: String): ScalaCourse =
    ScalaCourse("AdvancedScala", instructor)
}

object CaseClasses extends App {
  val scalaCourse = ScalaCourse("Scala")

  val numbers = Array(1, 2, 3, 4, 5)

  // Using a for loop to iterate over an array
  // for (num <- numbers) {
  //   println(s"Number: $num")
  // }

  numbers.map(number => println(s"Number: $number"))
}
