package leetCode._3200

import scala.collection.mutable.ListBuffer

object Solution_3123 {
  def findAnswer(n: Int, edges: Array[Array[Int]]): Array[Boolean] = {
    val g = Array.fill(n + 1)(ListBuffer.empty[Array[Int]])
    (0 until n).foreach(g(_) = ListBuffer.empty)
    edges.foreach(e => {
      g(e.head).append(Array(e(1), e(2)))
      g(e(1)).append(Array(e.head, e(2)))
    })
    val distSt = findAnswerDij(n, g, 0)
    val distEnd = findAnswerDij(n, g, n - 1)
    val len = edges.length
    val res = Array.fill(len)(false)
    edges.indices.foreach(i => {
      val e = edges(i)
      if (distSt(e.head) + e(2) + distEnd(e(1)) == distSt(n - 1)) res(i) = true
      if (distSt(e(1)) + e(2) + distEnd(e.head) == distSt(n - 1)) res(i) = true
    })
    res
  }

  private def findAnswerDij(n: Int, g: Array[ListBuffer[Array[Int]]], st: Int): Array[Long] = {
    val vis = Array.fill(n)(false)
    val dist = Array.fill(n)(Long.MaxValue / 2)
    dist(st) = 0
    val q = new java.util.PriorityQueue[Array[Long]](Ordering.by((_: Array[Long])(1)))
    q.add(Array(st.toLong, 0L))
    while (!q.isEmpty) {
      val poll = q.poll()
      if (vis(poll.head.toInt)) ()
      else {
        vis(poll.head.toInt) = true
        g(poll.head.toInt).foreach(end => if (dist(end.head) > poll(1) + end(1)) {
          dist(end.head) = poll(1) + end(1)
          q.add(Array(end.head.toLong, dist(end.head)))
        })
      }
    }
    dist
  }
}
