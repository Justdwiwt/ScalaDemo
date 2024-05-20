package leetCode._3200

object Solution_3155 {
  // fixme: case 572/574 wrong answer
  def maxUpgrades(count: Array[Int], upgrade: Array[Int], sell: Array[Int], money: Array[Int]): Array[Int] = count
    .zip(upgrade)
    .zip(sell)
    .zip(money)
    .map { case (((i, j), p), q) => i.min((q + p * i) / (j + p)) }
}
