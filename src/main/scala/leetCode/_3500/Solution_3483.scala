package leetCode._3500

object Solution_3483 {
  def totalNumbers(digits: Array[Int]): Int = digits
    .indices
    .flatMap(i => digits
      .indices
      .withFilter(_ != i)
      .flatMap(j => digits
        .indices
        .withFilter(k => k != i && k != j)
        .map(k => (digits(i), digits(j), digits(k)))))
    .filter { case (a, _, c) => a != 0 && c % 2 == 0 }
    .toSet
    .size
}
