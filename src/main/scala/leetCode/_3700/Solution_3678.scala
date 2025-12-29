package leetCode._3700

object Solution_3678 {
  def smallestAbsent(nums: Array[Int]): Int = {
    val set = nums.toSet
    val avg = nums.sum / nums.length
    Iterator.from((avg + 1).max(1), 1).find(!set.contains(_)).get
  }
}
