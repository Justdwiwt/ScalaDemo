package leetCode._3200

object Solution_3171 {
  def minimumDifference(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, res: Int): Int =
      if (i >= nums.length) res
      else {
        val x = nums(i)
        var newRes = res.min((x - k).abs)
        var j = i - 1
        while (j >= 0 && (nums(j) & x) != nums(j)) {
          nums(j) &= x
          newRes = newRes.min((nums(j) - k).abs)
          j -= 1
        }
        f(i + 1, newRes)
      }

    f(0, Int.MaxValue)
  }
}
