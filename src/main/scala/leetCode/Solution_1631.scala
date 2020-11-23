package leetCode

object Solution_1631 {

  class Cell(_effort: Int, _row: Int, _col: Int) {
    val effort: Int = _effort
    val row: Int = _row
    val col: Int = _col
  }

  val ordering: Ordering[Cell] = (n1: Cell, n2: Cell) => n1.effort.compareTo(n2.effort)

  def minimumEffortPath(heights: Array[Array[Int]]): Int = {
    if (heights.length == 0) 0
    else if (heights.length == 1 && heights.head.length == 1) 0
    else {
      var res = Int.MaxValue
      val pq = scala.collection.mutable.PriorityQueue[Cell]()(ordering.reverse)
      val dist = Array.fill(heights.length)(Array.fill(heights.head.length)(Int.MaxValue))
      val nextRowCol = Array(0, 1, 0, -1, 0)
      pq += new Cell(0, 0, 0)
      var flag = false
      while (pq.nonEmpty && !flag) {
        val curr = pq.dequeue
        val effort = curr.effort
        val row = curr.row
        val col = curr.col
        if (row == heights.length - 1 && col == heights.head.length - 1) {
          flag = true
          res = effort
        }
        var i = 0
        while (i < 4 && !flag) {
          val nrow = row + nextRowCol(i)
          val ncol = col + nextRowCol(i + 1)
          if (nrow >= 0 && nrow < heights.length && ncol >= 0 && ncol < heights.head.length) {
            val newDist = effort.max((heights(nrow)(ncol) - heights(row)(col)).abs)
            if (newDist < dist(nrow)(ncol)) {
              dist(nrow)(ncol) = newDist
              pq += new Cell(newDist, nrow, ncol)
            }
          }
          i += 1
        }
      }
      res
    }
  }
}
