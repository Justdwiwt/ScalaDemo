package leetCode._2700

object Solution_2611 {
  def miceAndCheese(reward1: Array[Int], reward2: Array[Int], k: Int): Int =
    reward2.sum + reward1.zip(reward2).map { case (r1, r2) => r1 - r2 }.sorted.takeRight(k).sum
}
