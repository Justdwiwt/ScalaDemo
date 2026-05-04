package leetCode._3900

object Solution_3871 {
  def countCommas(n: Long): Long = Iterator
    .iterate(1000L)(_ * 1000)
    .takeWhile(_ <= n)
    .map(n - _ + 1)
    .sum
}
