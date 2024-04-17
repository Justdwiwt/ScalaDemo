package leetCode._2800

object Solution_2702 {
  def minOperations(nums: Array[Int], x: Int, y: Int): Int = {
    val left = nums.map(num => (num + x - 1) / x.toLong).max
    val right = nums.map(num => (num + y - 1) / y.toLong).max

    def check(nums: Array[Int], x: Int, y: Int, time: Long): Boolean = {
      val centers = nums.map(num => {
        val d = x - y
        val ux = 0L.max((num - time * y + d - 1) / d)
        ux
      }).sum
      centers <= time
    }

    @scala.annotation.tailrec
    def binarySearch(left: Long, right: Long): Long =
      if (left >= right) left
      else {
        val mid = (right - left) / 2 + left
        if (check(nums, x, y, mid)) binarySearch(left, mid)
        else binarySearch(mid + 1, right)
      }

    binarySearch(left, right).toInt
  }
}
