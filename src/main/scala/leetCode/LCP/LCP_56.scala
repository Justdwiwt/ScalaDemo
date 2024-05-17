package leetCode.LCP

import scala.collection.immutable.Queue

object LCP_56 {
  private val directions: Array[(Int, Int)] = Array((-1, 0), (1, 0), (0, -1), (0, 1))

  private def isWithinBounds(x: Int, y: Int, m: Int, n: Int): Boolean =
    x >= 0 && x < m && y >= 0 && y < n

  private def computeDistance(map: Array[Array[Char]], m: Int, n: Int, start: Array[Int]): Array[Array[Int]] = {
    val initialDist = Array.fill(m, n)(1000000)
    val initialQueue = Queue(start)
    initialDist(start.head)(start(1)) = 0

    @scala.annotation.tailrec
    def bfs(queue: Queue[Array[Int]], dist: Array[Array[Int]]): Array[Array[Int]] = {
      if (queue.isEmpty) dist
      else {
        val (cur, restQueue) = queue.dequeue
        val (curX, curY) = (cur.head, cur(1))
        directions.foldLeft((dist, restQueue)) {
          case ((updatedDist, updatedQueue), (dx, dy)) =>
            val (newX, newY) = (curX + dx, curY + dy)
            if (isWithinBounds(newX, newY, m, n)) {
              val len = if (
                (dx == -1 && map(curX)(curY) == '^') ||
                  (dx == 1 && map(curX)(curY) == 'v') ||
                  (dy == -1 && map(curX)(curY) == '<') ||
                  (dy == 1 && map(curX)(curY) == '>')
              ) 0
              else 1
              val newDist = updatedDist(curX)(curY) + len
              if (newDist < updatedDist(newX)(newY)) {
                updatedDist(newX)(newY) = newDist
                (updatedDist, updatedQueue.enqueue(Array(newX, newY)))
              } else (updatedDist, updatedQueue)
            } else (updatedDist, updatedQueue)
        } match {
          case (newDist, newQueue) => bfs(newQueue, newDist)
        }
      }
    }

    bfs(initialQueue, initialDist)
  }

  def conveyorBelt(matrix: Array[String], start: Array[Int], end: Array[Int]): Int = {
    val m = matrix.length
    val n = matrix.head.length
    val map = matrix.map(_.toCharArray)
    val dist = computeDistance(map, m, n, start)
    dist(end.head)(end(1))
  }
}
