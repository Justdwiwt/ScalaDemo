package leetCode._1600

object Solution_1509 {
  def minDifference(nums: Array[Int]): Int = {
    if (nums.length <= 4) return 0
    val t = nums.sorted
    var res = Int.MaxValue
    (1 to 4).foreach(i => res = res.min(t(t.length - i) - t(4 - i)))
    res
  }
}
