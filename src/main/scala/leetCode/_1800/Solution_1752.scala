package leetCode._1800

object Solution_1752 {
  def check(nums: Array[Int]): Boolean = {
    if (nums.length < 2) return true
    val t = (nums :+ nums.head).sliding(2).count(arr => arr.head > arr(1))
    t == 1 || t == 0
  }
}
