package leetCode._3100

object Solution_3068 {
  def maximumValueSum(nums: Array[Int], k: Int, edges: Array[Array[Int]]): Long = {
    val bestSum = nums.map(n => n.toLong.max(k ^ n)).sum
    val cnt = nums.count(n => (n.toLong ^ k) > n)
    bestSum - (if (cnt % 2 == 0) 0 else nums.map(n => (n - (n.toLong ^ k)).abs).min)
  }
}
