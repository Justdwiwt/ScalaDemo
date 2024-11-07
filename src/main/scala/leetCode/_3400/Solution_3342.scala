package leetCode._3400

object Solution_3342 {
  val dirs: Array[(Int, Int)] = Array((1, 0), (-1, 0), (0, 1), (0, -1))

  def minTimeToReach(moveTime: Array[Array[Int]]): Int = {
    val n = moveTime.length
    val m = moveTime.head.length
    val dis = Array.fill(n, m)(Int.MaxValue)
    dis(0)(0) = 0

    implicit val ord: Ordering[(Int, Int, Int)] = Ordering.by[(Int, Int, Int), Int](_._1).reverse
    val pq = collection.mutable.PriorityQueue((0, 0, 0))(ord)

    @scala.annotation.tailrec
    def dijkstra(): Int =
      if (pq.isEmpty) Int.MaxValue
      else {
        val (d, i, j) = pq.dequeue()
        if (i == n - 1 && j == m - 1) d
        else if (d > dis(i)(j)) dijkstra()
        else {
          dirs.foreach { case (di, dj) =>
            val x = i + di
            val y = j + dj
            if (x >= 0 && x < n && y >= 0 && y < m) {
              val newDis = d.max(moveTime(x)(y)) + (i + j) % 2 + 1
              if (newDis < dis(x)(y)) {
                dis(x)(y) = newDis
                pq += ((newDis, x, y))
              }
            }
          }
          dijkstra()
        }
      }

    dijkstra()
  }
}
