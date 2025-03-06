package leetCode._3500

object Solution_3469 {
  def minCost(nums: Array[Int]): Int = {
    val n = nums.length
    val arr: Array[Int] = if (n % 2 == 1) nums.clone() else nums.map(_.max(nums.last))

    Range(n - 3 + n % 2, 0, -2)
      .map { i => val b = nums(i); (i, b) }
      .map { case (i, b) => val c = nums(i + 1); (i, b, c) }
      .foreach { case (i, b, c) => (0 until i)
        .map { j => val a = nums(j); (j, a) }
        .foreach { case (j, a) => arr(j) = (arr(j) + b.max(c)).min((arr(i) + a.max(c)).min(arr(i + 1) + a.max(b))) }
      }
    arr(0)
  }
}
