package leetCode._3600

object Solution_3502 {
  def minCosts(cost: Array[Int]): Array[Int] =
    cost.scanLeft(cost.head)((min, value) => min.min(value)).tail
}
