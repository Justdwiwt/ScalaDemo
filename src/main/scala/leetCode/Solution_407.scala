package leetCode

import scala.collection.mutable

object Solution_407 {
  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    if (heightMap.isEmpty) return 0
    val vis = Array.ofDim[Boolean](heightMap.length, heightMap.head.length)
    var pq = new mutable.PriorityQueue[Array[Int]]()(_ (2) - _ (2))
    heightMap.indices.foreach(i => heightMap.head.indices.foreach(j => {
      if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap.head.length - 1) {
        pq += Array(i, j, heightMap(i)(j))
        vis(i)(j) = true
      }
    }))
    var res = 0
    val diff = Array(-1, 0, 1, 0, -1)
    while (pq.nonEmpty) {
      val poll = pq.dequeue()
      (0 until 4).foreach(k => {
        val nx = poll.head + diff(k)
        val ny = poll(1) + diff(k + 1)
        if (nx >= 0 && nx < heightMap.length && ny >= 0 && ny < heightMap.head.length && !vis(nx)(ny)) {
          if (poll(2) > heightMap(nx)(ny)) res += poll(2) - heightMap(nx)(ny)
          pq += Array(nx, ny, heightMap(nx)(ny).max(poll(2)))
          vis(nx)(ny) = true
        }
      })
    }
    res
  }
}
