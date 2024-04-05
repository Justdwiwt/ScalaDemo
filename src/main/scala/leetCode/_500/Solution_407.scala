package leetCode._500

import scala.collection.immutable.TreeSet

object Solution_407 {
  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    val (m, n) = (heightMap.length, heightMap.head.length)
    val border = heightMap.indices.flatMap(r => heightMap.head.indices.withFilter(c => r == 0 || c == 0 || r == m - 1 || c == n - 1).map((r, _)))

    @scala.annotation.tailrec
    def f(toVisit: TreeSet[(Int, Int, Int)], visited: Set[(Int, Int)], prevLevel: Int, res: Int): Int = {
      if (toVisit.isEmpty) res
      else {
        val (height, r, c) = toVisit.head
        val level = prevLevel.max(height)
        val newToVisit = toVisit.tail
        val newVisited = visited + ((r, c))
        val newResult = Seq((r - 1, c), (r, c - 1), (r, c + 1), (r + 1, c))
          .filter { case (nr, nc) => nr >= 0 && nr < m && nc >= 0 && nc < n && !visited.contains((nr, nc)) }
          .foldLeft((newToVisit, newVisited, res)) { case ((toVisit, visited, result), (nr, nc)) =>
            val waterTrapped = (level - heightMap(nr)(nc)).max(0)
            val neiToVisit = (heightMap(nr)(nc), nr, nc)
            (toVisit + neiToVisit, visited + ((nr, nc)), result + waterTrapped)
          }
        f(newResult._1, newResult._2, level, newResult._3)
      }
    }

    val toVisit = TreeSet(border.map { case (r, c) => (heightMap(r)(c), r, c) }: _*)
    f(toVisit, Set.empty, 0, 0)
  }
}
