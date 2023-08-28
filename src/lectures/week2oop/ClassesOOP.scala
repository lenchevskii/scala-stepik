package lectures.week2oop

class Student(val name: String)

val student = new Student("Sam")

class Employee(val name: String, var salary: Double) {
  def this() = this("John", 0.0)
}

class Instructor(val id: Int, name: String, surname: String) {
  def fullName: String =
    name.head.toUpper +
      name.tail.toLowerCase +
      " " +
      surname.head.toUpper +
      surname.tail.toLowerCase
}

class Course(
    courseId: Int,
    title: String,
    val releaseYear: String,
    instructor: Instructor
) {
  def getId = s"${courseId}${instructor.id}"

  def isTaughtBy(instructor: Instructor) = instructor match
    case this.instructor => true
    case _               => false

  def copyCourse(newReleaseYear: String) =
    new Course(this.courseId, this.title, newReleaseYear, this.instructor)
}

object ClassesOOP extends App {
  val instructor = new Instructor(1, "bobby", "fisher")
  val falseInstructor = new Instructor(1, "bobby", "fisher")
  val course = new Course(20, "Scala", "2023", instructor)

  println(course.getId);
  println(course.isTaughtBy(falseInstructor))
  println(course.copyCourse("2020"))
}
