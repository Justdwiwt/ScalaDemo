package leetCode

object Solution_974 {
  def subarraysDivByK(A: Array[Int], K: Int): Int = A
    .scanLeft(0)(_ + _)
    .map(x => (x % K + K) % K)
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .map(x => x * (x - 1) / 2)
    .sum
}
