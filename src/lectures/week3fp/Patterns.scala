package lectures.week3fp

def guard = (data: Any, maxLength: Int) =>
  data match
    case list: List[Any] if list.length <= maxLength =>
      "A List of acceptable length is provided."
    case list: List[Any] =>
      "The length of the list exceeds the maximum allowed value."
    case str: String if str.length <= maxLength =>
      "The length of the string does not exceed the maximum allowed value."
    case str: String =>
      "An invalid string length is received."
    case _ =>
      "What is this? It's neither a string nor a list."

object Patterns extends App {}
