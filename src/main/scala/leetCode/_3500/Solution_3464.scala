package leetCode._3500

object Solution_3464 {
  def maxDistance(side: Int, points: Array[Array[Int]], k: Int): Int = {
    val a = points.map {
      case Array(x, y) if x == 0 => y.toLong
      case Array(x, y) if y == side => side + x.toLong
      case Array(x, y) if x == side => side * 3L - y.toLong
      case Array(x, _) => side * 4L - x.toLong
    }.sorted

    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int =
      if (left + 1 >= right) left
      else {
        val mid = (left + right) / 2
        if (check(a, side, k, mid)) binarySearch(mid, right)
        else binarySearch(left, mid)
      }

    binarySearch(1, side + 1)
  }

  private def check(a: Array[Long], side: Int, k: Int, low: Int): Boolean = a.exists(start => {
    val end = start + side * 4L - low
    var cur = start
    (1 until k).foldLeft[Boolean](true)((found, _) => {
      if (!found) false
      else {
        val j = lowerBound(a, cur + low)
        if (j == a.length || a(j) > end) false
        else {
          cur = a(j)
          true
        }
      }
    })
  })

  private def lowerBound(nums: Array[Long], target: Long): Int = {
    @scala.annotation.tailrec
    def loop(left: Int, right: Int): Int =
      if (left + 1 < right) {
        val mid = (left + right) / 2
        if (nums(mid) >= target) loop(left, mid)
        else loop(mid, right)
      } else right

    loop(-1, nums.length)
  }
}
