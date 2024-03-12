package leetCode._1500

object Solution_1402 {
  def maxSatisfaction(satisfaction: Array[Int]): Int = satisfaction
    .sorted
    .reverse
    .scan(0)(_ + _)
    .takeWhile(_ >= 0)
    .sum
}
