package leetCode

object Solution_2401 {
  def longestNiceSubarray(nums: Array[Int]): Int = {
    var mask = 0
    var mx = 1
    var i = 0
    var j = 0
    while (i < nums.length) {
      while ((mask & nums(i)) != 0) {
        mask ^= nums(j)
        j += 1
      }
      mask ^= nums(i)
      mx = mx.max(i - j + 1)
      i += 1
    }
    mx
  }
}
