package leetCode._1000

object Solution_978 {
  def maxTurbulenceSize(A: Array[Int]): Int = A./:(0, 0, A.headOption.getOrElse(0), 0L) {
    case ((b, l, pre, diff), n) =>
      val len = if (pre == n) 1
      else if (diff * (n - pre) > 0L) 2
      else l + 1
      (b.max(len), len, n, n - pre)
  }._1
}
