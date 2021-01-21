package leetCode

object Solution_1221 {
  def balancedStringSplit(s: String): Int =
    s./:((0, 0))((acc, ch) => acc match {
      case (1, cnt) if ch == 'L' => (0, cnt + 1)
      case (-1, cnt) if ch == 'R' => (0, cnt + 1)
      case (flag, cnt) if ch == 'R' => (flag + 1, cnt)
      case (flag, cnt) if ch == 'L' => (flag - 1, cnt)
    })._2
}
