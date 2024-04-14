package leetCode.LCP

object LCS_03 {
  private val mx = Array(0, 1, 0, -1)
  private val my = Array(1, 0, -1, 0)

  def largestArea(grid: Array[String]): Int = {
    val ch = grid.map(_.toCharArray)
    val (m, n) = (grid.length, grid.head.length)

    def bfs(i: Int, j: Int): Int = {
      @scala.annotation.tailrec
      def f(queue: collection.mutable.Queue[(Int, Int)], visited: Set[(Int, Int)], cnt: Int): Int = {
        if (queue.isEmpty) cnt
        else {
          val (x, y) = queue.dequeue
          val newCount = cnt + 1
          val neighbors = (0 until 4)
            .map(k => (x + mx(k), y + my(k)))
            .filter { case (nx, ny) => nx >= 0 && nx < m && ny >= 0 && ny < n && ch(nx)(ny) == ch(x)(y) && !visited((nx, ny)) }
          ch(x)(y) = 'x'
          f(queue ++ neighbors, visited ++ neighbors, newCount)
        }
      }

      if (i < 0 || j < 0 || i >= m || j >= n || ch(i)(j) == 'x') 0
      else {
        val initialQueue = collection.mutable.Queue((i, j))
        f(initialQueue, Set((i, j)), 0)
      }
    }

    grid.indices.foreach(i => grid.head.indices.foreach(j =>
      if (grid(i)(j) == '0') (0 until 4).foreach(k => bfs(i + mx(k), j + my(k)))
      else if (i == 0 || j == 0 || i == m - 1 || j == n - 1) bfs(i, j)
    ))

    grid
      .indices
      .flatMap(i => grid.head.indices.collect { case j if grid(i)(j) != '0' && ch(i)(j) != 'x' => bfs(i, j) })
      .foldLeft(0)(_.max(_))
  }
}
