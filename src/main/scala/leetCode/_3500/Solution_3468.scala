package leetCode._3500

object Solution_3468 {
  def countArrays(original: Array[Int], bounds: Array[Array[Int]]): Int = {
    val (mn, mx) = original.zip(bounds).foldLeft((Int.MinValue, Int.MaxValue)) {
      case ((curMn, curMx), (x, Array(u, v))) =>
        (curMn.max(u - x), curMx.min(v - x))
    }
    0.max(mx - mn + 1)
  }
}
