package leetCode._700

object Solution_646 {
  def findLongestChain(pairs: Array[Array[Int]]): Int = pairs
    .sortBy(_(1))
    .foldLeft((0, Integer.MIN_VALUE))((acc, e) => if (e.head > acc._2) (acc._1 + 1, e(1)) else acc)
    ._1
}
