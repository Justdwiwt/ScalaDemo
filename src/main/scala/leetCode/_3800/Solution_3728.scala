package leetCode._3800

object Solution_3728 {
  def countStableSubarrays(capacity: Array[Int]): Long =
    if (capacity.length < 2) 0L
    else capacity
      .sliding(2)
      .foldLeft((Map.empty[(Int, Long), Long], capacity(0).toLong, 0L)) {
        case ((cnt, s, ans), Array(a, b)) =>
          val k = (a, a.toLong + s)
          val c2 = cnt.updated(k, cnt.getOrElse(k, 0L) + 1)
          (c2, s + b, ans + cnt.getOrElse((b, s), 0L))
      }
      ._3
}
