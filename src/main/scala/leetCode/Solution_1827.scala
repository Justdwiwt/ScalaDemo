package leetCode

object Solution_1827 {
  def minOperations(nums: Array[Int]): Int = nums./:((0, 0)) {
    case ((s, t), n) => if (t < n) (s, n) else (s + t - n + 1, t + 1)
  }._1
}
