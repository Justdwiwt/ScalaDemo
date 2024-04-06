package leetCode._400

object Solution_330 {
  def minPatches(nums: Array[Int], n: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, miss: Long, res: Int): Int =
      if (miss > n) res
      else if (i < nums.length && nums(i) <= miss) f(i + 1, miss + nums(i), res)
      else f(i, miss + miss, res + 1)

    f(0, 1L, 0)
  }
}
