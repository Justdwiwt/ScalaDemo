package leetCode._900

object Solution_822 {
  def flipgame(fronts: Array[Int], backs: Array[Int]): Int = (fronts ++ backs)
    .sorted
    .find(x => !fronts
      .zip(backs)
      .filter(x => x._1 == x._2)
      .map(_._1)
      .toSet
      .contains(x))
    .getOrElse(0)
}
