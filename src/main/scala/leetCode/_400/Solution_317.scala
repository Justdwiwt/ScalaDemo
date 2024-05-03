package leetCode._400

import scala.collection.mutable

object Solution_317 {
  def shortestDistance(grid: Array[Array[Int]]): Int = {
    val dirs = Array((1, 0), (-1, 0), (0, 1), (0, -1))
    val rows = grid.length
    val cols = grid.head.length
    val total = Array.ofDim[Int](rows, cols)
    var emptyLandValue = 0
    var minDist = Int.MaxValue

    grid.indices.foreach(row => grid.head.indices.foreach(col => if (grid(row)(col) == 1) {
      minDist = Int.MaxValue
      val q = mutable.Queue.empty[(Int, Int)]
      q.enqueue((row, col))
      var steps = 0
      while (q.nonEmpty) {
        steps += 1
        q.indices.foreach(_ => {
          val (currRow, currCol) = q.dequeue()
          dirs.foreach { case (dx, dy) =>
            val (nextRow, nextCol) = (currRow + dx, currCol + dy)
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid(nextRow)(nextCol) == emptyLandValue) {
              grid(nextRow)(nextCol) -= 1
              total(nextRow)(nextCol) += steps
              q.enqueue((nextRow, nextCol))
              minDist = minDist.min(total(nextRow)(nextCol))
            }
          }
        })
      }
      emptyLandValue -= 1
    }))

    if (minDist == Int.MaxValue) -1 else minDist
  }
}
