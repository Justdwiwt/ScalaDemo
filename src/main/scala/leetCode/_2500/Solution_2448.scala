package leetCode._2500

object Solution_2448 {
  def minCost(nums: Array[Int], cost: Array[Int]): Long = {
    def calc(tgt: Int): Long = nums
      .indices
      .map(i => (nums(i) - tgt).abs.toLong * cost(i))
      .sum

    @scala.annotation.tailrec
    def f(lo: Int, hi: Int): Long = {
      lazy val mid = (lo + hi) >>> 1
      lazy val (x, y) = (calc(mid), calc(mid + 1))
      if ((hi - lo) < 2) calc(hi).min(calc(lo))
      else if (x > y) f(mid + 1, hi)
      else f(lo, mid)
    }

    f(nums.min, nums.max)
  }
}
