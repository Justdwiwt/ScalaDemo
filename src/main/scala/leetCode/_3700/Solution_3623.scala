package leetCode._3700

object Solution_3623 {
  def countTrapezoids(points: Array[Array[Int]]): Int = {
    val M = 1000000007

    points
      .groupBy(_(1))
      .values
      .map(_.length.toLong)
      .filter(_ > 1)
      .map(c => c * (c - 1) / 2)
      .foldLeft((0L, 0L)) { case ((ans, s), k) =>
        val newAns = (ans + s * k) % M
        val newS = (s + k) % M
        (newAns, newS)
      }._1.toInt
  }
}
