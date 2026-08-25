package leetCode._4000

object Solution_3970 {
  def shortestPath(n: Int, edges: Array[Array[Int]], labels: String, k: Int): Int = {
    val g = Array.fill(n)(collection.mutable.ArrayBuffer.empty[(Int, Int)])

    edges.foreach { case Array(x, y, w) => g(x) += ((y, w)) }

    val inf = Int.MaxValue
    val dis = Array.fill(n, k + 1)(inf)
    val pq = collection.mutable.PriorityQueue.empty[(Int, Int, Int)](Ordering.by[(Int, Int, Int), Int](-_._1))

    dis(0)(1) = 0
    pq.enqueue((0, 0, 1))

    while (pq.nonEmpty) {
      val (d, x, cnt) = pq.dequeue()

      if (x == n - 1) return d

      if (d == dis(x)(cnt)) {
        g(x).foreach { case (y, w) =>
          val newCnt = if (labels(y) == labels(x)) cnt + 1 else 1

          val newDis = d + w

          if (newCnt <= k && newDis < dis(y)(newCnt)) {
            dis(y)(newCnt) = newDis
            pq.enqueue((newDis, y, newCnt))
          }
        }
      }
    }

    -1
  }
}
