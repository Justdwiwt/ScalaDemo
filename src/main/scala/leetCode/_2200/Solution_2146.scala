package leetCode._2200

import scala.collection.mutable.ListBuffer

object Solution_2146 {
  private val dirs = Array(Array(-1, 0), Array(1, 0), Array(0, -1), Array(0, 1))

  def highestRankedKItems(grid: Array[Array[Int]], pricing: Array[Int], start: Array[Int], k: Int): List[List[Int]] = {
    val ans = ListBuffer.empty[List[Int]]
    val m = grid.length
    val n = grid.head.length
    val vis = Array.ofDim[Boolean](m, n)
    vis(start.head)(start(1)) = true
    var q = List(start)
    var found = false
    while (q.nonEmpty && !found) {
      q = q.sortWith { (a, b) =>
        val pa = grid(a.head)(a(1))
        val pb = grid(b.head)(b(1))
        if (pa != pb) pa < pb
        else if (a.head != b.head) a.head < b.head
        else a(1) < b(1)
      }
      q.foreach(p => {
        val (x, y) = (p.head, p(1))
        if (pricing.head <= grid(x)(y) && grid(x)(y) <= pricing(1)) {
          ans += List(x, y)
          if (ans.size == k) found = true
        }
      })
      if (!found) {
        val tmp = ListBuffer.empty[List[Int]]
        q.foreach(p => dirs.foreach(d => {
          val (x, y) = (p.head + d.head, p(1) + d(1))
          if (0 <= x && x < m && 0 <= y && y < n && !vis(x)(y) && grid(x)(y) > 0) {
            vis(x)(y) = true
            tmp += List(x, y)
          }
        }))
        q = tmp.map(_.toArray).toList
      }
    }
    ans.toList.take(k)
  }
}
