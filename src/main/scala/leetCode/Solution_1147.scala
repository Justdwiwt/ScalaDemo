package leetCode

object Solution_1147 {
  @scala.annotation.tailrec
  def longestDecomposition(text: String, i: Int = 1, res: Int = 0): Int =
    if (text.isEmpty) res
    else if (i > text.length / 2) res + 1
    else if (text.take(i) == text.takeRight(i)) longestDecomposition(text.drop(i).dropRight(i), 1, res + 2)
    else longestDecomposition(text, i + 1, res)
}
