package leetCode

object Solution_2496 {
  def maximumValue(strs: Array[String]): Int = strs
    .map(s => if (s.forall(_.isDigit)) s.toInt else s.length)
    .max
}
