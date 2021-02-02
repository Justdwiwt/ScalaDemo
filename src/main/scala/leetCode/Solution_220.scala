package leetCode

object Solution_220 {
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    def check(l: Int, r: Int): Boolean =
      (l until r).exists(idx => (nums(idx).toLong - nums(r).toLong).abs <= t)

    @scala.annotation.tailrec
    def f(l: Int, r: Int): Boolean =
      if (r >= nums.length) false
      else if (r - l < k) check(l, r) || f(l, r + 1)
      else check(l, r) || f(l + 1, r + 1)

    f(0, 0)
  }
}
