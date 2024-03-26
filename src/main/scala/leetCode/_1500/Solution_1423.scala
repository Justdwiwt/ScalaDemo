package leetCode._1500

object Solution_1423 {
  def maxScore(cardPoints: Array[Int], k: Int): Int = cardPoints
    .scanLeft(0)(_ + _)
    .take(k + 1)
    .zip(cardPoints.scanRight(0)(_ + _).takeRight(k + 1))
    .map(n => n._1 + n._2)
    .max
}
