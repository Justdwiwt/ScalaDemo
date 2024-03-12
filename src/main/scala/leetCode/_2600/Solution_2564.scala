package leetCode._2600

object Solution_2564 {
  def substringXorQueries(s: String, queries: Array[Array[Int]]): Array[Array[Int]] = {
    val pairings = (30 to 1 by -1)
      .flatMap(sz => (s.length - sz to 0 by -1).map(l => Integer.parseInt(s.slice(l, l + sz), 2) -> Array(l, l + sz - 1)))
    val map = pairings.toMap.withDefaultValue(Array(-1, -1))
    queries.map { case Array(i, j) => map(i ^ j) }
  }
}
