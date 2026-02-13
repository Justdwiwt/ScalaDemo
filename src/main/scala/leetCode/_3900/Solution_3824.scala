package leetCode._3900

object Solution_3824 {
  def minimumK(nums: Array[Int]): Int = {
    val n = nums.length.toLong
    val sum = nums.foldLeft(0L)(_ + _)

    def nonPositive(k: Long): Long =
      n + nums.foldLeft(0L)((acc, x) => acc + (x - 1) / k)

    @scala.annotation.tailrec
    def binarySearch(l: Long, r: Long): Long =
      if (l >= r) l
      else {
        val mid = (l + r) >>> 1
        if (nonPositive(mid) <= mid * mid)
          binarySearch(l, mid)
        else
          binarySearch(mid + 1, r)
      }

    binarySearch(1L, sum).toInt
  }
}
