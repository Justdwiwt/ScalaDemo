package leetCode._3200

object Solution_3155 {
  private def ceilDivide(a: Long, b: Long): Long =
    (a + b - 1) / b

  def maxUpgrades(count: Array[Int], upgrade: Array[Int], sell: Array[Int], money: Array[Int]): Array[Int] = count
    .zip(upgrade)
    .zip(sell)
    .zip(money)
    .map {
      case (((c, u), s), m) =>
        val maxUpgrade = c.min(c - ceilDivide(c.toLong * u - m, u + s).toInt)
        maxUpgrade
    }
}
