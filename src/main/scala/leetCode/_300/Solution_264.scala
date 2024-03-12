package leetCode._300

object Solution_264 {
  val ugly: Stream[Int] = 1 #:: union(union(ugly.map(2 * _), ugly.map(3 * _)), ugly.map(5 * _))

  def union(x: Stream[Int], y: Stream[Int]): Stream[Int] =
    if (x.head < y.head) x.head #:: union(x.tail, y)
    else if (x.head == y.head) x.head #:: union(x.tail, y.tail)
    else y.head #:: union(x, y.tail)

  def nthUglyNumber(n: Int): Int = ugly(n - 1)
}
