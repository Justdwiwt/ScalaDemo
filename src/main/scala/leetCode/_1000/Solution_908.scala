package leetCode._1000

object Solution_908 {
  def smallestRangeI(A: Array[Int], K: Int): Int = {
    0.max(A.max - A.min - 2 * K)
  }
}
