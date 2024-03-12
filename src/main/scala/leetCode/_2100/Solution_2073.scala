package leetCode._2100

object Solution_2073 {
  def timeRequiredToBuy(tickets: Array[Int], k: Int): Int = tickets
    .indices
    .filter(_ <= k)
    .map(i => tickets(i).min(tickets(k)))
    .sum + tickets
    .indices
    .filter(_ > k)
    .map(i => tickets(i).min(tickets(k) - 1))
    .sum
}
