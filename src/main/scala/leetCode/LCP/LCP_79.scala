package leetCode.LCP

import scala.collection.mutable

object LCP_79 {
  def extractMantra(matrix: Array[String], mantra: String): Int = {
    val m = matrix.length
    val n = matrix.head.length
    val q = mutable.Queue((0, 0, 0))
    var vis = Set(q.head)

    def isValidPosition(x: Int, y: Int): Boolean =
      x >= 0 && x < m && y >= 0 && y < n

    def getNextPositions(i: Int, j: Int): Seq[(Int, Int)] =
      Seq((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))

    def exploreCell(i: Int, j: Int, k: Int): Boolean = {
      if (matrix(i)(j) == mantra(k))
        if (k == mantra.length - 1) return true
        else {
          val p = (i, j, k + 1)
          if (!vis.contains(p)) {
            vis += p
            q.enqueue(p)
          }
        }
      false
    }

    var step = 1
    var res = -1

    while (q.nonEmpty && res == -1) {
      val tmp = q.clone()
      q.clear()
      tmp.foreach { case (i, j, k) =>
        if (exploreCell(i, j, k)) res = step

        getNextPositions(i, j)
          .filter { case (x, y) => isValidPosition(x, y) }
          .foreach { case (x, y) =>
            val p = (x, y, k)
            if (!vis.contains(p)) {
              vis += p
              q.enqueue(p)
            }
          }
      }
      step += 1
    }
    res
  }
}
