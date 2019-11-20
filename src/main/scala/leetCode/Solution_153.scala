package leetCode

object Solution_153 {
  def findMin(nums: Array[Int]): Int = {
    @annotation.tailrec
    def func(lo: Int, hi: Int): Int = {
      if (lo >= hi) nums(lo)
      else {
        val m = lo + (hi - lo) / 2
        if (nums(m) < nums(hi)) func(lo, m) else func(m + 1, hi)
      }
    }

    func(0, nums.length - 1)
  }
}
