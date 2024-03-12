package leetCode._1900

object Solution_1816 {
  def truncateSentence(s: String, k: Int): String = s
    .split(" ")
    .take(k)
    .mkString(" ")
}
