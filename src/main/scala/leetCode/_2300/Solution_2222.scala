package leetCode._2300

object Solution_2222 {
  def numberOfWays(s: String): Long = s./:(0L, 0L, 0L, s.count(_ == '1'), s.count(_ == '0')) {
    case ((ways, onesBefore, zeroesBefore, onesAfter, zeroesAfter), n) =>
      if (n == '1') (ways + zeroesBefore * zeroesAfter, onesBefore + 1, zeroesBefore, onesAfter - 1, zeroesAfter)
      else (ways + onesBefore * onesAfter, onesBefore, zeroesBefore + 1, onesAfter, zeroesAfter - 1)
  }._1
}
