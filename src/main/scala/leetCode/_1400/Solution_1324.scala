package leetCode._1400

object Solution_1324 {
  def printVertically(s: String): List[String] = {
    def f(s: String): String = s.replaceAll("\\s+$", "")

    val splitWords = s.split(" ").map(_.toCharArray)
    (0 until splitWords.map(_.length).max)./:(List.empty[String])((a, b) => {
      f(splitWords.map(_.lift(b).getOrElse(' ')).mkString) :: a
    }).reverse
  }
}
