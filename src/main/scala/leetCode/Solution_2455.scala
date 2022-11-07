package leetCode

object Solution_2455 {
  def averageValue(nums: Array[Int]): Int = {
    val (s, c) = nums.filter(_ % 6 == 0)./:((0, 0)) { case ((s, c), e) => (s + e, c + 1) }
    if (c == 0) 0 else s / c
  }
}
