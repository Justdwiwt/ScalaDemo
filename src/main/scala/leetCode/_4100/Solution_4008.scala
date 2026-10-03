package leetCode._4100

object Solution_4008 {
  def minInitialStrength(monsters: Array[Int], boosts: Array[Array[Int]]): Long = {
    val n = monsters.length
    val bonus = Array.fill[Long](n + 1)(0L)

    boosts.foreach {
      case Array(l, r, v) =>
        bonus(l) += v
        bonus(r + 1) -= v
    }

    monsters.indices.drop(1).foreach(i => bonus(i) += bonus(i - 1))

    (n - 1 to 0 by -1)
      .find(i => monsters(i) > bonus(i))
      .fold(0L)(i => monsters.take(i + 1).map(_.toLong).sum - bonus(i))
  }
}
