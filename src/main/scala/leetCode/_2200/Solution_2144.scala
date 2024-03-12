package leetCode._2200

object Solution_2144 {
  def minimumCost(cost: Array[Int]): Int = cost
    .sorted
    .reverse
    .grouped(3)
    .flatMap(_.take(2))
    .sum
}
