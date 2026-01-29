package leetCode._3800

object Solution_3783 {
  def mirrorDistance(n: Int): Int =
    (n - n.toString.reverse.toInt).abs
}
