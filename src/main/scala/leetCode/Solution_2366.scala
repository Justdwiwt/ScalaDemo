package leetCode

object Solution_2366 {
  def minimumReplacement(nums: Array[Int]): Long = {
    val n = nums.length
    var res = 0L
    (n - 2 to 0 by -1).foreach(i => {
      if (nums(i) > nums(i + 1)) {
        var t = (nums(i) - 1) / nums(i + 1)
        res += t
        nums(i) /= (t + 1)
      }
    })
    res
  }
}
