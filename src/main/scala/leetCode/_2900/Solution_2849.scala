package leetCode._2900

object Solution_2849 {
  def isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean = {
    val step = (fx - sx).abs.max((fy - sy).abs)
    if (step == 0) t != 1 else step <= t
  }
}
