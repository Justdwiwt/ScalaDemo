package leetCode._2200

object Solution_2194 {
  def cellsInRange(s: String): List[String] = (s(0) to s(3))
    .flatMap(col => (s(1) to s(4)).map(row => col.toString + row))
    .toList
}
