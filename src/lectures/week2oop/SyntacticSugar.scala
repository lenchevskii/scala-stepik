package lectures.week2oop

class Person(val name: String, occupation: String) {
  def worksAs(jobName: String): Boolean = jobName == occupation

  def speaksEnglish: Boolean = true

  // def apply(company: String): String =
  //   s"$name works as a $occupation in $company"

  def apply(person: Person): String = s"$name "

  def isDeveloper: Boolean = this worksAs "Scala Developer"

  def unary_+ : Person = new Person(name + " NoSurname", " ")
}

object SyntacticSugar extends App {
  val bob = new Person("Bob", "Developer")

  val person = new Person("Bob", "Developer")
  println((+person).name)

  println(bob.isDeveloper)
}
