package leetCode

object Solution_2438 {
  val M = 1000000007

  def productQueries(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    val powers = f(1, n).toArray
    queries.collect { case Array(l, r) => l.to(r).map(powers)./:(1L)((m, el) => (m * el) % M).toInt }
  }

  def f(mask: Int, n: Int): List[Int] = {
    val bit = mask & n
    if (mask >= M) List.empty
    else if (bit > 0) bit :: f(mask << 1, n)
    else f(mask << 1, n)
  }
}
