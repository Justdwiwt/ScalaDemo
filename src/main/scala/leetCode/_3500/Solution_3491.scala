package leetCode._3500

object Solution_3491 {
  def phonePrefix(numbers: Array[String]): Boolean = numbers
    .indices
    .flatMap(i => numbers
      .indices
      .withFilter(i != _)
      .withFilter(numbers(_).startsWith(numbers(i)))
      .map(_ => true))
    .isEmpty
}
