package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_2876 {
  def countVisitedNodes(edges: List[Int]): Array[Int] = {
    val g = edges.toArray
    val n = g.length
    val rg = Array.fill(n)(mutable.ListBuffer.empty[Int])
    val deg = Array.fill(n)(0)

    g.indices.foreach(x => {
      val y = g(x)
      rg(y).append(x)
      deg(y) += 1
    })

    val q = mutable.Queue.empty[Int]
    deg.indices.filter(i => deg(i) == 0).foreach(q += _)

    while (q.nonEmpty) {
      val x = q.dequeue()
      val y = g(x)
      deg(y) -= 1
      if (deg(y) == 0) q += y
    }

    val res = Array.fill(n)(0)
    g.indices.foreach(i => if (deg(i) > 0) {
      val ring = mutable.ListBuffer.empty[Int]
      var x = i
      breakable({
        while (true) {
          deg(x) = -1
          ring.append(x)
          if (g(x) == i) break
          x = g(x)
        }
      })
      ring.foreach(r => rdfs(r, ring.size, rg, deg, res))
    })
    res
  }

  private def rdfs(x: Int, depth: Int, rg: Array[mutable.ListBuffer[Int]], deg: Array[Int], res: Array[Int]): Unit = {
    res(x) = depth
    rg(x).foreach(y => if (deg(y) == 0) rdfs(y, depth + 1, rg, deg, res))
  }
}
