package leetCode._1000

object Solution_910 {
  def smallestRangeII(A: Array[Int], K: Int): Int = {
    val sortedA = A.sorted

    @scala.annotation.tailrec
    def f(idx: Int, mn: Int): Int =
      if (idx == sortedA.length - 1) mn
      else {
        val high = (sortedA(A.length - 1) - K).max(sortedA(idx) + K)
        val low = (sortedA.head + K).min(sortedA(idx + 1) - K)
        f(idx + 1, mn.min(high - low))
      }

    f(0, sortedA(A.length - 1) - sortedA.head)
  }
}
