package leetCode._3000

object Solution_2931 {
  def maxSpending(values: Array[Array[Int]]): Long = {
    val (m, n) = (values.length, values.head.length)
    values.flatten.sorted.zip(1 to m * n).map { case (v, day) => v.toLong * day }.sum
  }
}
