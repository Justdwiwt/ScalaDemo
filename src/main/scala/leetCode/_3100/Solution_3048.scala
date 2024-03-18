package leetCode._3100

object Solution_3048 {
  def earliestSecondToMarkIndices(nums: Array[Int], changeIndices: Array[Int]): Int = {
    val n = nums.length
    val m = changeIndices.length
    if (n > m) return -1

    val done = Array.fill(n)(0)
    var left = n - 1
    var right = m + 1
    while (left + 1 < right) {
      val mid = (left + right) >>> 1
      if (check(nums, changeIndices, done, mid)) right = mid
      else left = mid
    }
    if (right > m) -1 else right
  }

  private def check(nums: Array[Int], changeIndices: Array[Int], done: Array[Int], mx: Int): Boolean = {
    var exam = nums.length
    var study = 0
    var idx = mx - 1
    while (idx >= 0 && study <= idx + 1) {
      val t = changeIndices(idx) - 1
      if (done(t) != mx) {
        done(t) = mx
        exam -= 1
        study += nums(t)
      } else if (study > 0) study -= 1
      idx -= 1
    }
    exam == 0 && study == 0
  }
}
