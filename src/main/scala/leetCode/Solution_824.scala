package leetCode

object Solution_824 {
  def toGoatLatin(S: String): String = S.split("\\s+").zipWithIndex.map(t => t._1.take(1) match {
    case "a" | "i" | "o" | "u" | "e" => t._1 + "ma" + "a" * (1 + t._2)
    case "A" | "I" | "O" | "U" | "E" => t._1 + "ma" + "a" * (1 + t._2)
    case x => t._1.tail + x + "ma" + "a" * (1 + t._2)
  }).mkString(" ")
}
