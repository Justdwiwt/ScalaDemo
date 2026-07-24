package leetCode._4000

object Solution_3951 {
  def minEnergy(n: Int, brightness: Int, intervals: Array[Array[Int]]): Long = {
    val (left, right, sum) = intervals.sortBy(_.head).foldLeft((0, -1, 0L)) {
      case ((pl, pr, s), Array(l, r)) =>
        if (l <= pr) (pl, pr.max(r), s)
        else (l, r, s + pr - pl + 1L)
    }

    val total = sum + right - left + 1L
    total * ((brightness + 2) / 3).toLong
  }
}
