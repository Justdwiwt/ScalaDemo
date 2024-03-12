package leetCode._1900

object Solution_1838 {
  def maxFrequency(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted

    @scala.annotation.tailrec
    def f(i: Int = 0, j: Int = 0, sum: Long = 0L, c: Int = 1): Int =
      if (j == nums.length) c
      else {
        val _sum = sum + sorted(j)
        val _c = j - i + 1
        if (_sum + k < sorted(j).toLong * _c) f(i + 1, j, sum - sorted(i), c)
        else f(i, j + 1, _sum, c.max(_c))
      }

    f()
  }
}
