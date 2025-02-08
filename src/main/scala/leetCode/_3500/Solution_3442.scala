package leetCode._3500

object Solution_3442 {
  def maxDifference(s: String): Int = {
    val cnt = s.groupBy(identity).mapValues(_.length)
    val maxOdd = cnt.values.filter(_ % 2 == 1).reduceOption(_.max(_)).getOrElse(0)
    val minEven = cnt.values.filter(_ % 2 == 0).reduceOption(_.min(_)).getOrElse(0)
    maxOdd - minEven
  }
}
