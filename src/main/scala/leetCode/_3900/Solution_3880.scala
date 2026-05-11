package leetCode._3900

object Solution_3880 {
  def minAbsoluteDifference(nums: Array[Int]): Int = nums
    .indices
    .flatMap(i => nums
      .indices
      .withFilter(_ => nums(i) == 1)
      .withFilter(nums(_) == 2)
      .map(j => (i - j).abs))
    .reduceOption(_.min(_))
    .getOrElse(-1)
}
