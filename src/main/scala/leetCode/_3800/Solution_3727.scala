package leetCode._3800

object Solution_3727 {
  def maxAlternatingSum(nums: Array[Int]): Long = {
    val a = nums.map(v => 1L * v * v).sorted
    val k = a.length / 2
    a.drop(k).sum - a.take(k).sum
  }
}
