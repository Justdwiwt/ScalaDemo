package leetCode._3800

object Solution_3747 {
  def countDistinct(n: Long): Long = {
    val (ans, pow9) = n
      .toString
      .reverse
      .view
      .map(_ - '0')
      .foldLeft((0L, 1L)) {
        case ((_, p), 0) => (0L, p * 9)
        case ((a, p), d) if p > 1 => (a + (d - 1) * p, p * 9)
        case ((a, p), d) => (a + d * p, p * 9)
      }

    ans + (pow9 - 9) / 8
  }
}
