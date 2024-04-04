package leetCode._600

object Solution_576 {
  def findPaths(m: Int, n: Int, maxMoves: Int, startRow: Int, startColumn: Int): Int = maxMoves match {
    case 0 => 0
    case maxMoves =>
      val totalPaths = Array.tabulate(m, n) {
        case (i, j) if i == startRow && j == startColumn => 1
        case _ => 0
      }

      @scala.annotation.tailrec
      def comp(move: Int, path: Array[Array[Int]], pathPlus: Array[Array[Int]]): Unit = {
        if (move < maxMoves) {
          (0 until m).foreach(i => (0 until n).foreach(j => {
            pathPlus(i)(j) = Iterator((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1))
              .collect { case (i, j) if path.isDefinedAt(i) && path(i).isDefinedAt(j) => path(i)(j) }
              .fold(0)(add)
            totalPaths(i)(j) = add(totalPaths(i)(j), pathPlus(i)(j))
          }))

          comp(move + 1, pathPlus, path)
        }
      }

      comp(1, totalPaths.map(_.clone), Array.fill(m, n)(0))
      Iterator
        .range(0, m)
        .flatMap(i => Iterator((i, 0), (i, n - 1)))
        .++(Iterator.range(0, n).flatMap(j => Iterator((0, j), (m - 1, j))))
        .map { case (i, j) => totalPaths(i)(j) }
        .fold(0)(add)
  }

  private def add(x: Int, y: Int): Int =
    (x + y) % 1000000007
}
