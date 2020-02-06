package leetCode

import scala.util.control.Breaks._

object Solution_661 {
  def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
    if (M.isEmpty || M(0).isEmpty) return Array.empty
    val res = M
    val dirs = Array(Array(0, -1), Array(-1, -1), Array(-1, 0), Array(-1, 1),
      Array(0, 1), Array(1, 1), Array(1, 0), Array(1, -1))
    M.indices.foreach(i => M(0).indices.foreach(j => {
      var cnt = M(i)(j)
      var all = 1
      dirs.foreach(dir => {
        val x = i + dir(0)
        val y = j + dir(1)
        breakable {
          if (x < 0 || x >= M.length || y < 0 || y >= M(0).length) break()
        }
        all += 1
        cnt += M(x)(y)
      })
      res(i)(j) = cnt / all
    }))
    res
  }
}
