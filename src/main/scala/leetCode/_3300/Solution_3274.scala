package leetCode._3300

object Solution_3274 {
  def checkTwoChessboards(s: String, t: String): Boolean =
    (s.head.toInt + s(1).toInt) % 2 == (t.head.toInt + t(1).toInt) % 2
}
