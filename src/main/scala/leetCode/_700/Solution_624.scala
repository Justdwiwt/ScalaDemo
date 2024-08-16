package leetCode._700

object Solution_624 {
  def maxDistance(arrays: List[List[Int]]): Int = arrays
    .map(_.head)
    .zipWithIndex
    .sorted
    .take(2)
    .flatMap { case (a, i) => arrays
      .map(_.last)
      .zipWithIndex
      .sorted
      .reverse
      .take(2)
      .withFilter { case (_, j) => i != j }
      .map { case (b, _) => b - a }
    }.max
}
