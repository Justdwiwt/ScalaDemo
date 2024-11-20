package leetCode._3400

object Solution_3356 {
  def minZeroArray(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    def check(k: Int): Boolean = {
      val diff = Array.fill(nums.length + 1)(0)
      queries.take(k).foreach { case Array(l, r, value) =>
        diff(l) += value
        if (r + 1 < diff.length) diff(r + 1) -= value
      }
      val prefixSum = diff.scanLeft(0)(_ + _).tail
      nums.zip(prefixSum).forall { case (x, sum_d) => x <= sum_d }
    }

    val n = queries.length

    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int =
      if (left + 1 >= right) right
      else {
        val mid = (left + right) / 2
        if (check(mid)) binarySearch(left, mid)
        else binarySearch(mid, right)
      }

    val res = binarySearch(-1, n + 1)
    if (res <= n) res else -1
  }
}
