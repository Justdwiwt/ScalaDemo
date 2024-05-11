package leetCode._600

import scala.collection.mutable

object Solution_505 {
  def shortestDistance(maze: Array[Array[Int]], start: Array[Int], dest: Array[Int]): Int = {
    val n = maze.length
    val m = maze.head.length
    val pq = mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by(_._3))
    pq += ((start.head, start(1), 0))

    val dir = Array(-1, 0, 1, 0, -1)
    val arr = Array.fill(n, m)(Int.MaxValue)

    def updateDistance(x: Int, y: Int, distance: Int): Unit = {
      (0 until 4).foreach(k => {
        var newX = x
        var newY = y
        var newDistance = distance
        while (newX >= 0 && newX < n && newY >= 0 && newY < m && maze(newX)(newY) == 0) {
          newX += dir(k)
          newY += dir(k + 1)
          newDistance += 1
        }
        newX -= dir(k)
        newY -= dir(k + 1)
        newDistance -= 1
        if (arr(newX)(newY) > newDistance) {
          arr(newX)(newY) = newDistance
          pq += ((newX, newY, newDistance))
        }
      })
    }

    while (pq.nonEmpty) {
      val (x, y, distance) = pq.dequeue()
      updateDistance(x, y, distance)
    }

    val res = arr(dest.head)(dest(1))
    if (res == Int.MaxValue) -1 else res
  }
}
