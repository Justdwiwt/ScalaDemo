package leetCode._3800

object Solution_3745 {
  def maximizeExpressionOfThree(nums: Array[Int]): Int = {
    val s = nums.sorted
    s.last + s.init.last - s.head
  }
}
