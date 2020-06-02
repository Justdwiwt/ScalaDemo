package leetCode

object Solution_1422 {
  def maxScore(s: String): Int = {
    (1 until s.length).map(i => s.splitAt(i)).map(x => x._1.count(_ == '0') + x._2.count(_ == '1')).max
  }
}
