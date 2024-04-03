package leetCode._3100

object Solution_3097 {
  def minimumSubarrayLength(nums: Array[Int], k: Int): Int = {
    if (k == 0) return 1

    @scala.annotation.tailrec
    def f(start: Int, end: Int, sum: Int, minLen: Int): Int =
      if (end >= nums.length) if (minLen == nums.length + 1) -1 else minLen
      else {
        val newSum = sum | nums(end)
        if (newSum >= k) {
          val newMinLen = math.min(minLen, end - start + 1)
          f(start + 1, start + 1, 0, newMinLen)
        } else f(start, end + 1, newSum, minLen)
      }

    f(0, 0, 0, nums.length + 1)
  }
}
