package leetCode

object Solution_2027 {
  def minimumMoves(s: String): Int =
    ((s.length - s.replaceAll("X.?.?", "").length) / 3.0).ceil.toInt
}
