package leetCode

object Solution_1534 {
  def countGoodTriplets(arr: Array[Int], a: Int, b: Int, c: Int): Int = arr
    .indices
    .dropRight(2)
    .flatMap(i => arr.indices.drop(1).dropRight(1).flatMap(j => arr.drop(i + j + 1).map(Array(arr(i), arr(i + j), _))))
    .count(t => (t.head - t(1)).abs <= a && (t(1) - t(2)).abs <= b && (t.head - t(2)).abs <= c)
}
