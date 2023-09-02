package lectures.week3fp

object Collections extends App {
  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  val xs = for {
    lng <- progLanguages
    abrv <- lngAbbrev
    if lngAbbrev.indexOf(abrv) == progLanguages.indexOf(lng)
  } yield (abrv, lng)

  // println(Seq(3,4,3,3).sorted.search(3))
  // Array.ofDim[String](1).foreach(println)
  // val sampleTuple = new Tuple2(2, "Hello, World")
  // println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)
}
