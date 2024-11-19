package leetCode._3400

object Solution_3355 {
  def isZeroArray(nums: Array[Int], queries: Array[Array[Int]]): Boolean = {
    val n = nums.length
    val diff = Array.fill(n + 1)(0)
    queries.foreach { case Array(l, r) =>
      diff(l) += 1
      if (r + 1 < diff.length) diff(r + 1) -= 1
    }
    val prefixSum = diff.scanLeft(0)(_ + _).tail
    nums.zip(prefixSum).forall { case (x, sum_d) => x <= sum_d }
  }
}
