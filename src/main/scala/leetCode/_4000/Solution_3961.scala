package leetCode._4000

object Solution_3961 {
  def maxRatings(units: Array[Array[Int]]): Long =
    if (units.head.length == 1) units.map(_.head.toLong).sum
    else {
      val sorted = units.map(_.sorted)
      val ans = sorted.map(_(1).toLong).sum
      val mn = sorted.map(_(0).toLong).min
      val mn2 = sorted.map(_(1).toLong).min
      ans + mn - mn2
    }
}
