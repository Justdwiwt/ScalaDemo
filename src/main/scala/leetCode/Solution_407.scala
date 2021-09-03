package leetCode

import scala.collection.mutable

object Solution_407 {
  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    val diff = List((1, 0), (0, 1), (-1, 0), (0, -1))
    val n = if (heightMap.length == 0) 0 else heightMap.head.length
    var res = 0
    val pq = mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by(_._3)).reverse
    val seen = Array.fill(heightMap.length, n)(false)
    heightMap.indices.foreach(i => {
      pq += ((i, 0, heightMap(i).head))
      pq += ((i, n - 1, heightMap(i)(n - 1)))
      seen(i)(0) = true
      seen(i)(n - 1) = true
    })
    (1 until n - 1).foreach(j => {
      pq += ((0, j, heightMap.head(j)))
      pq += ((heightMap.length - 1, j, heightMap(heightMap.length - 1)(j)))
      seen.head(j) = true
      seen(heightMap.length - 1)(j) = true
    })
    while (pq.nonEmpty) {
      val cell = pq.dequeue()
      diff.foreach(d => {
        val i = cell._1 + d._1
        val j = cell._2 + d._2
        if (i >= 0 && i < heightMap.length && j >= 0 && j < n && !seen(i)(j)) {
          res += 0.max(cell._3 - heightMap(i)(j))
          pq += ((i, j, heightMap(i)(j).max(cell._3)))
          seen(i)(j) = true
        }
      })
    }
    res
  }
}
