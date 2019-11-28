package leetCode

object Solution_60 {
  def getPermutation(n: Int, k: Int): String = {
    val t = (1 to n).permutations
    (1 until k).foreach(_ => if (t.hasNext) t.next())
    if (t.nonEmpty) return t.next().toList.mkString
    ""
  }
}
