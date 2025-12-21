package leetCode._3700

object Solution_3653 {
  def xorAfterQueries(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    val M = 1000000007
    val tmp = nums.map(_.toLong)
    queries
      .withFilter { case Array(l, r, k, v) => true; case _ => false }
      .foreach { case Array(l, r, k, v) => (l to r by k).foreach(i => tmp(i) = (tmp(i) * v) % M) }
    tmp.reduce(_ ^ _).toInt
  }
}
