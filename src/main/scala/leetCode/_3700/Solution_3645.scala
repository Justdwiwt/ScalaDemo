package leetCode._3700

object Solution_3645 {
  def maxTotal(value: Array[Int], limit: Array[Int]): Long = value
    .zip(limit)
    .groupBy(_._2)
    .map { case (l, vs) => vs.map(_._1).sorted.reverse.take(l).map(_.toLong).sum }
    .sum
}
