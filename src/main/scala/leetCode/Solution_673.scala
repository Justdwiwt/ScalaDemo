package leetCode

object Solution_673 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def g(i: Int, j: Int, maxLen: Int, count: Int, a: Array[(Int, Int)]): (Int, Int) =
      if (j >= nums.length) (maxLen, count)
      else if (nums(i) < nums(j)) {
        val (len, c) = a(j)
        g(i, j + 1, maxLen.max(len + 1), if (len + 1 > maxLen) c else if (len + 1 == maxLen) c + count else count, a)
      }
      else g(i, j + 1, maxLen, count, a)

    @scala.annotation.tailrec
    def f(i: Int, maxLen: Int, count: Int, a: Array[(Int, Int)]): Int =
      if (i < 0) count
      else {
        a(i) = g(i, i + 1, 1, 1, a)
        val (len, c) = a(i)
        f(i - 1, maxLen.max(len), if (len > maxLen) c else if (len == maxLen) count + c else count, a)
      }

    f(nums.length - 2, 1, 1, Array.fill(nums.length)(1 -> 1))
  }
}
