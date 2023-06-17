package leetCode

object Solution_2733 {
  def findNonMinOrMax(nums: Array[Int]): Int = {
    if (nums.length < 3) -1
    else nums.take(3).sorted.take(2).last
  }
}
