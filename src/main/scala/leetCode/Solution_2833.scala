package leetCode

object Solution_2833 {
  def furthestDistanceFromOrigin(moves: String): Int = {
    val (left, right) = moves./:((0, 0)) { case ((l, r), v) =>
      if (v == 'L') (l - 1, r - 1)
      else if (v == 'R') (l + 1, r + 1)
      else (l - 1, r + 1)
    }

    left.abs.max(right.abs)
  }
}
