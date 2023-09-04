package lectures.week3fp

def concatenator(s1: String, s2: String, s3: String) = s1 + s2 + s3

val insertName = concatenator("This is ", _: String, " course")

val aPartialFunction: PartialFunction[String, String] =
  case "hello"     => "Hi, I'm Bot"
  case "bye"       => "Bye-bye"
  case "what's up" => "sup-sup"

val chatBot = aPartialFunction.lift

object PartialFunctions extends App {

  val xs: List[String] = List("Hello", "What's up", "bye")

  xs.map(chatBot.andThen(println))
}
