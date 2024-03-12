package leetCode._1200

object Solution_1189 {
  def maxNumberOfBalloons(text: String): Int = "balon"
    .toList
    .zip(List(1, 1, 2, 2, 1))
    .map(p => text.count(_ == p._1) / p._2)
    .min
}
