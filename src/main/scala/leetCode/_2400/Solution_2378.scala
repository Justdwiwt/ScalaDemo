package leetCode._2400

import scala.collection.mutable.ArrayBuffer

object Solution_2378 {
  def maxScore(edges: Array[Array[Int]]): Long = {
    val n = edges.length
    if (n == 0) return 0L
    val g = Array.fill(n)(ArrayBuffer[(Int, Int)]())
    edges.indices.drop(1).foreach(i => {
      val x = edges(i)(0)
      val y = edges(i)(1)
      g(x) += ((i, y))
    })

    def dfs(x: Int): (Long, Long) = {
      val first = new ArrayBuffer[Long]()
      val second = new ArrayBuffer[Long]()
      val edge = new ArrayBuffer[Int]()
      g(x).foreach { case (j, e) =>
        val (f, s) = dfs(j)
        first += f
        second += s
        edge += e
      }
      val ss = first.sum
      var res = ss
      (first, second, edge).zipped.foreach { case (f, s, e) => res = res.max(e.toLong + s + ss - f) }
      (res, ss)
    }

    dfs(0)._1
  }
}
