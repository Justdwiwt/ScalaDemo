package leetCode._1500

object Solution_1422 {
  def maxScore(s: String): Int = s
    .indices
    .drop(1)
    .map(i => s.splitAt(i))
    .map(x => x._1.count(_ == '0') + x._2.count(_ == '1'))
    .max
}
