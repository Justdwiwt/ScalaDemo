package leetCode._3800

object Solution_3740 {
  def minimumDistance(nums: Array[Int]): Int = nums
    .zipWithIndex
    .groupBy(_._1)
    .map { case (_, pairs) => pairs.map(_._2) }
    .flatMap(is => is.zip(is.drop(2)).map { case (a, c) => (c - a) * 2 })
    .reduceOption(_.min(_))
    .getOrElse(-1)
}
