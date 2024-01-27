package leetCode

object Solution_3011 {
  def canSortArray(nums: Array[Int]): Boolean = {
    val n = nums.length
    var i = 0
    while (i < n) {
      val start = i
      val ones = java.lang.Integer.bitCount(nums(i))
      i = i + 1
      while (i < n && Integer.bitCount(nums(i)) == ones) i += 1
      java.util.Arrays.sort(nums, start, i)
    }
    nums.indices.drop(1).foreach(i => if (nums(i) < nums(i - 1)) return false)
    true
  }
}
