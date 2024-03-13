package leetCode._3000

object Solution_2931 {
  def maxSpending(values: Array[Array[Int]]): Long = values
    .flatten
    .sorted
    .zip(1 to values.length * values.head.length)
    .map { case (v, day) => v.toLong * day }
    .sum
}
