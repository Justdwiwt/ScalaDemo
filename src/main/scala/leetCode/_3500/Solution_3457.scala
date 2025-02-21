package leetCode._3500

object Solution_3457 {
  def maxWeight(pizzas: Array[Int]): Long = {
    val sortedPizzas = pizzas.sorted
    val n = sortedPizzas.length
    val days = n / 4
    val odd = (days + 1) / 2

    val oddSum = sortedPizzas.takeRight(odd).map(BigInt(_)).sum
    val evenSum = sortedPizzas.dropRight(odd).takeRight(days / 2 * 2).grouped(2).map(_.head).map(BigInt(_)).sum

    (oddSum + evenSum).toLong
  }
}
