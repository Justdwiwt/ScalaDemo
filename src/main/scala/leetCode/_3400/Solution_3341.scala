package leetCode._3400

object Solution_3341 {
  val dirs: Array[(Int, Int)] = Array((-1, 0), (1, 0), (0, -1), (0, 1))

  def minTimeToReach(moveTime: Array[Array[Int]]): Int = {
    val n = moveTime.length
    val m = moveTime.head.length
    val times = Array.fill(n, m)(Int.MaxValue)
    times(0)(0) = 0

    implicit val ord: Ordering[(Int, Int, Int)] = Ordering.by(_._3)
    val pq = scala.collection.mutable.PriorityQueue[(Int, Int, Int)]()(ord.reverse)
    pq += ((0, 0, 0))

    @scala.annotation.tailrec
    def dijkstra(): Int =
      if (pq.isEmpty || times(n - 1)(m - 1) != Int.MaxValue) times(n - 1)(m - 1)
      else {
        val (row, col, time) = pq.dequeue()
        if (times(row)(col) < time) dijkstra()
        else {
          dirs.foreach { case (dr, dc) =>
            val newRow = row + dr
            val newCol = col + dc
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
              val newTime = time.max(moveTime(newRow)(newCol)) + 1
              if (times(newRow)(newCol) > newTime) {
                times(newRow)(newCol) = newTime
                pq += ((newRow, newCol, newTime))
              }
            }
          }
          dijkstra()
        }
      }

    dijkstra()
  }
}
