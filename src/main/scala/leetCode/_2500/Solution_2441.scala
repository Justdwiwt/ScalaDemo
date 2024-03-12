package leetCode._2500

object Solution_2441 {
  def findMaxK(nums: Array[Int]): Int = {
    val filtered = nums.filter(n => n > 0 && nums.contains(-n))
    if (filtered.isEmpty) -1 else filtered.max
  }
}
