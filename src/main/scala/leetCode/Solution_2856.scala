package leetCode

object Solution_2856 {
  def minLengthAfterRemovals(nums: List[Int]): Int = {
    val len = nums.length
    var res = nums.length
    var i = 0
    var j = (len + 1) / 2
    while (i < len / 2 && j < len) {
      if (nums(i) < nums(j)) res -= 2
      i += 1
      j += 1
    }
    res
  }
}
