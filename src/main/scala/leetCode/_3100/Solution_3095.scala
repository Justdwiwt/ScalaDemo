package leetCode._3100

object Solution_3095 {
  def minimumSubarrayLength(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def findMinEnd(start: Int, value: Int): Int =
      if (start < nums.length) {
        val newValue = value | nums(start)
        if (newValue >= k) start
        else findMinEnd(start + 1, newValue)
      } else -1

    @scala.annotation.tailrec
    def f(i: Int, minSubarray: Int): Int =
      if (i < nums.length) {
        val minEnd = findMinEnd(i, 0)
        if (minEnd >= 0) {
          val newMinSubarray = minSubarray.min(minEnd - i + 1)
          f(i + 1, newMinSubarray)
        } else f(i + 1, minSubarray)
      } else if (minSubarray != Int.MaxValue) minSubarray else -1

    f(0, Int.MaxValue)
  }
}
