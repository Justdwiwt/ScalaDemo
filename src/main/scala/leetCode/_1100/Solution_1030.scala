package leetCode._1100

object Solution_1030 {
  def allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array[Array[Int]] = (0 until rows)
    .flatMap(i => (0 until cols).map(Array(i, _)))
    .sortBy(s => (s.head - rCenter).abs + (s(1) - cCenter).abs)
    .toArray
}
