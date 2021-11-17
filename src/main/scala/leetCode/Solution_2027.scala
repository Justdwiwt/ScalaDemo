package leetCode

object Solution_2027 {
  def minimumMoves(s: String): Int = {
    var res, i = 0
    while (i < s.length) {
      if (s(i) == 'X') {
        i += 2
        res += 1
      }
      i += 1
    }
    res
  }
}
