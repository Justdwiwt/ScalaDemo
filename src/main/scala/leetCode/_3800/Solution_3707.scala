package leetCode._3800

object Solution_3707 {
  def scoreBalance(s: String): Boolean = s
    .toList
    .map(_ - 'a' + 1.0)
    .scanLeft(0.0)(_ + _)
    .exists(_ == s.toList.map(_ - 'a' + 1.0).sum / 2)
}
