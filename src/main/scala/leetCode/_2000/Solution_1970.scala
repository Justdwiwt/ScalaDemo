package leetCode._2000

object Solution_1970 {
  def latestDayToCross(numRows: Int, numCols: Int, cells: Array[Array[Int]]): Int = {
    val waterByDay = cells
      .indices
      .scanLeft(Set[(Int, Int)]()) {
        case (water, i) => cells(i) match {
          case Array(row, col) => water + (row -> col)
          case cell => throw new IllegalArgumentException(cell.mkString("Array(", ", ", ")"))
        }
      }

    @scala.annotation.tailrec
    def latestDayToCross(start: Int, end: Int): Int =
      if (end - start == 1) start
      else {
        val mid = (start + end) >>> 1
        if (canCross(waterByDay(mid))) latestDayToCross(mid, end)
        else latestDayToCross(start, mid)
      }

    def canCross(water: Set[(Int, Int)]) = {
      @scala.annotation.tailrec
      def canCross(states: Set[(Int, Int)], visited: Set[(Int, Int)]): Boolean = {
        if (states.isEmpty) false
        else if (states.exists(_._1 == numRows)) true
        else canCross(
          states.flatMap({
            case (row, col) => Iterable((row - 1) -> col, (row + 1) -> col, row -> (col - 1), row -> (col + 1))
              .filter({ case (row, col) => (1 to numRows).contains(row) && (1 to numCols).contains(col) })
              .filterNot(water.contains)
              .filterNot(states.contains)
              .filterNot(visited.contains)
          }),
          visited ++ states)
      }

      canCross((1 to numCols).map(1 -> _).filterNot(water.contains).toSet, Set())
    }

    latestDayToCross(0, waterByDay.size)
  }
}
