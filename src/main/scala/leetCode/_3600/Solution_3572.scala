package leetCode._3600

object Solution_3572 {
  def maxSumDistinctTriplet(x: Array[Int], y: Array[Int]): Int = {
    val bestPerX = x
      .zip(y)
      .groupBy(_._1)
      .mapValues(_.map(_._2).max)
      .values
      .toSeq

    if (bestPerX.size < 3) -1
    else bestPerX.sorted(Ordering.Int.reverse).take(3).sum
  }
}
