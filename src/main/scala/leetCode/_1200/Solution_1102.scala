package leetCode._1200

object Solution_1102 {
  def maximumMinimumPath(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    val visited: Array[Array[Boolean]] = Array.ofDim[Boolean](m, n)
    val queue = new java.util.PriorityQueue[Array[Int]]((a: Array[Int], b: Array[Int]) => b(2) - a(2))
    queue.add(Array(0, 0, grid.head.head))
    val arr = Array(Array(1, 0), Array(-1, 0), Array(0, 1), Array(0, -1))

    @scala.annotation.tailrec
    def bfs(): Int = {
      if (queue.isEmpty) -1
      else {
        val cell = queue.poll()
        val row: Int = cell.head
        val col: Int = cell(1)

        if (row == m - 1 && col == n - 1) cell(2)
        else {
          visited(row)(col) = true
          arr.foreach(dir => {
            val newX = row + dir.head
            val newY = col + dir(1)
            if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited(newX)(newY))
              queue.add(Array(newX, newY, grid(newX)(newY).min(cell(2))))
          })
          bfs()
        }
      }
    }

    bfs()
  }
}
