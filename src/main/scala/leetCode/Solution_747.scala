package leetCode

object Solution_747 {
  def dominantIndex(nums: Array[Int]): Int = {
    val idx = nums.indexOf(nums.max)
    nums.indices.foreach(i => if (idx != i && nums(idx) < 2 * nums(i)) return -1)
    idx
  }
}
