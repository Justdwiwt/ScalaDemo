package leetCode._2300

object Solution_2202 {
  def maximumTop(nums: Array[Int], k: Int): Int = {
    if (nums.length == 1) return if (k % 2 == 1) -1 else nums(0)
    var res = 0
    nums.indices.foreach(i => if (k == i || k >= i + 2) res = res.max(nums(i)))
    res
  }
}
