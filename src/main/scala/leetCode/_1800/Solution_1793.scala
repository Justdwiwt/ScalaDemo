package leetCode._1800

object Solution_1793 {
  def maximumScore(nums: Array[Int], k: Int): Int = {
    val mnLeft = nums.take(k).scanRight(nums(k))(_.min(_))
    val mnRight = nums.drop(k + 1).scanLeft(nums(k))(_.min(_))

    @annotation.tailrec
    def f(left: Int, right: Int, mxScore: Int = nums(k)): Int =
      if (left < k && right > k) {
        val minLeft = mnLeft(left)
        val minRight = mnRight(right - k)
        if (minLeft < minRight) f(left + 1, right, mxScore.max((right - left + 1) * minLeft))
        else f(left, right - 1, mxScore.max((right - left + 1) * minRight))
      } else if (left < k) f(left + 1, right, mxScore.max((k - left + 1) * mnLeft(left)))
      else if (right > k) f(left, right - 1, mxScore.max((right - k + 1) * mnRight(right - k)))
      else mxScore

    f(0, nums.length - 1)
  }
}
