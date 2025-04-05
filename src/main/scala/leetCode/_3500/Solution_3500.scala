package leetCode._3500

object Solution_3500 {
  def minimumCost(nums: Array[Int], cost: Array[Int], k: Int): Long = {
    val n = nums.length
    val sumNums = nums.scanLeft(0L)(_ + _)
    val s = cost.scanLeft(0L)(_ + _)

    val vec = (1 to n).foldLeft(Vector(0L))((dp, i) => {
      val minCost = (0 until i).map(j => dp(j) + sumNums(i) * (s(i) - s(j)) + k * (s(n) - s(j))).min
      dp :+ minCost
    })

    vec(n)
  }
}
