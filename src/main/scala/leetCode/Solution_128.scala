package leetCode

object Solution_128 {
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val arr = nums.sorted
    var mx = 1
    var curr = 1
    var i = 0
    var j = 1
    while (j < arr.length) {
      if (arr(j) == arr(i) + 1) curr += 1
      else if (arr(j) > arr(i) + 1) {
        mx = mx.max(curr)
        curr = 1
      }
      i += 1
      j += 1
    }
    mx.max(curr)
  }
}
