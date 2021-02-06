package leetCode

object Solution_198 {
  def rob(nums: Array[Int]): Int = nums./:((0, 0)) {
    case ((prev, max), num) => (max, max.max(prev + num))
  }._2
}
