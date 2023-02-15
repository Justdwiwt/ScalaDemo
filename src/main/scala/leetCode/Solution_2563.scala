package leetCode

object Solution_2563 {
  def countFairPairs(nums: Array[Int], lower: Int, upper: Int): Long = {
    val sorted = nums.sorted

    @scala.annotation.tailrec
    def f(i: Int = 0, j: Int = sorted.length - 1, bound: Int, res: Long = 0L): Long =
      if (i == j) res
      else if (sorted(i) + sorted(j) > bound) f(i, j - 1, bound, res)
      else f(i + 1, j, bound, res + j - i)

    f(bound = upper) - f(bound = lower - 1)
  }
}
