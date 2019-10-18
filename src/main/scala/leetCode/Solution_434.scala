package leetCode

object Solution_434 {
  def countSegments(s: String): Int = {
    var res = 0
    for (i <- 0 until s.length)
      if ((i == 0 || s(i - 1) == ' ') && s(i) != ' ') res += 1
    res
  }
}
