package leetCode._2900

import scala.collection.mutable

object Solution_2812 {
  private val row = Array(0, 0, -1, 1)
  private val col = Array(-1, 1, 0, 0)

  private def bfs(grid: List[List[Int]], score: Array[Array[Int]], n: Int): Unit = {
    val q = mutable.Queue.empty[(Int, Int)]

    (0 until n).foreach(i => (0 until n).foreach(j => if (grid(i)(j) == 1) {
      score(i)(j) = 0
      q.enqueue((i, j))
    }))

    while (q.nonEmpty) {
      val (x, y) = q.dequeue()
      val s = score(x)(y)

      (0 until 4).foreach(i => {
        val newX = x + row(i)
        val newY = y + col(i)

        if (newX >= 0 && newX < n && newY >= 0 && newY < n && score(newX)(newY) > 1 + s) {
          score(newX)(newY) = 1 + s
          q.enqueue((newX, newY))
        }
      })
    }
  }

  def maximumSafenessFactor(grid: List[List[Int]]): Int = {
    val n = grid.size
    if (grid.head.head == 1 || grid(n - 1)(n - 1) == 1) return 0

    val score = Array.fill(n, n)(Int.MaxValue)
    bfs(grid, score, n)

    val vis = Array.fill(n, n)(false)
    val pq = new java.util.PriorityQueue[Array[Int]]((a: Array[Int], b: Array[Int]) => b.head - a.head)
    pq.add(Array(score.head.head, 0, 0))

    while (!pq.isEmpty) {
      val tmp = pq.poll()
      val safe = tmp.head
      val i = tmp(1)
      val j = tmp(2)

      if (i == n - 1 && j == n - 1) return safe
      vis(i)(j) = true

      (0 until 4).foreach(k => {
        val newX = i + row(k)
        val newY = j + col(k)

        if (newX >= 0 && newX < n && newY >= 0 && newY < n && !vis(newX)(newY)) {
          val s = safe.min(score(newX)(newY))
          pq.add(Array(s, newX, newY))
          vis(newX)(newY) = true
        }
      })
    }

    -1
  }
}
