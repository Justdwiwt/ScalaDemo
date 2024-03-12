package leetCode._500

object Solution_500 {
  def findWords(words: Array[String]): Array[String] = {
    val m = Map[Int, String](1 -> "qwertyuiop", 2 -> "asdfghjkl", 3 -> "zxcvbnm").flatMap({ case (k, v) => v.map(_ -> k) })
    words.filter(_.toLowerCase.map(m).toSet.size == 1)
  }
}
