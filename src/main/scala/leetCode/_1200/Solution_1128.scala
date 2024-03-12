package leetCode._1200

object Solution_1128 {
  def numEquivDominoPairs(A: Array[Array[Int]]): Int = A
    .map(_.sorted)
    .groupBy(x => (x.head, x(1)))
    .values
    .map(_.length)
    .withFilter(_ > 1)
    .map(x => x * (x - 1) / 2)
    .sum
}
