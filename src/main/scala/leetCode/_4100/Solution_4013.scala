package leetCode._4100

object Solution_4013 {
  def countRatioSubarrays(nums: Array[Int], a: Int, b: Int): Long = {
    val prefix = nums.scanLeft(0L) {
      case (sum, x) => sum + (if (x % 2 == 1) a else -b)
    }

    def mergeCount(xs: Array[Long]): Long = {
      if (xs.length <= 1) 0L
      else {
        val (left, right) = xs.splitAt(xs.length / 2)
        val cnt = mergeCount(left) + mergeCount(right)

        var l = 0
        var r = 0

        xs.indices.foldLeft(cnt) { (ans, i) =>
          if (l < left.length &&
            (r == right.length || left(l) <= right(r))) {
            xs(i) = left(l)
            l += 1
            ans
          } else {
            xs(i) = right(r)
            r += 1
            ans + l
          }
        }
      }
    }

    mergeCount(prefix)
  }
}
