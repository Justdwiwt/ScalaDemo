package leetCode

import scala.collection.mutable

object Solution_1617 {
  def countSubgraphsForEachDiameter(n: Int, edges: Array[Array[Int]]): Array[Int] = {
    val graph = mutable.Map.empty[Int, List[Int]]
    edges.foreach(edge => {
      graph.get(edge.head - 1) match {
        case Some(xs) => graph(edge.head - 1) = xs :+ (edge(1) - 1)
        case None => graph(edge.head - 1) = List(edge(1) - 1)
      }
      graph.get(edge(1) - 1) match {
        case Some(xs) => graph(edge(1) - 1) = xs :+ (edge.head - 1)
        case None => graph(edge(1) - 1) = List(edge.head - 1)
      }
    })

    val dist = Array.ofDim[Int](n, n)
    (0 until n).foreach(i => calcDist(dist, i, n, graph))

    val res = Array.fill[Int](n - 1)(0)

    (1 until (1 << n)).foreach(mask => {
      var cities = 0
      var maxDist = 0
      var oneDist = 0
      (0 until n).foreach(j => mask & (1 << j) match {
        case 0 =>
        case _ =>
          cities = cities + 1
          (j + 1 until n).foreach(k => mask & (1 << k) match {
            case 0 =>
            case _ =>
              maxDist = maxDist.max(dist(k)(j))
              if (dist(k)(j) == 1) oneDist += 1
          })
      })
      if (cities - 1 == oneDist && maxDist > 0) res(maxDist - 1) += 1
    })
    res
  }

  def calcDist(dist: Array[Array[Int]], source: Int, n: Int, graph: mutable.Map[Int, List[Int]]) {
    val q = mutable.Queue.empty[Int]
    val visited = Array.fill[Boolean](n)(false)
    q += source
    var d = 0
    while (q.nonEmpty) {
      var size = q.length
      while (size > 0) {
        val cur = q.dequeue()
        dist(cur)(source) = d
        dist(source)(cur) = d
        visited(cur) = true
        graph(cur).foreach(next => if (!visited(next)) q.enqueue(next))
        size = size - 1
      }
      d = d + 1
    }
  }
}
