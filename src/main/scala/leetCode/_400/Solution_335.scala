package leetCode._400

object Solution_335 {
  def isSelfCrossing(distance: Array[Int]): Boolean =
    distance.padTo(6, 0).sliding(6).exists { case Array(a, b, c, d, e, f) =>
      d >= b && b > 0 && (a >= c || (a >= c - e && c - e >= 0 && f >= d - b))
    }
}
