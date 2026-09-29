package leetCode._4100

object Solution_4003 {
  def minCost(m: Int, n: Int, penalty: Array[Array[Int]]): Long = {
    case class Node(d: Long, i: Int, j: Int, k: Int)

    val pq = new java.util.PriorityQueue[Node](java.util.Comparator.comparingLong[Node](_.d))

    val dis = Array.fill(m, n, 2)(Long.MaxValue)

    dis(0)(0)(1) = 1L
    pq.offer(Node(1L, 0, 0, 1))

    val dirs = Array((0, -1), (0, 1), (-1, 0), (1, 0))

    while (!pq.isEmpty) {
      val Node(d, i, j, k) = pq.poll()

      if (i == m - 1 && j == n - 1)
        return d

      if (d <= dis(i)(j)(k)) {
        val p = penalty(i)(j)
        val nextK = k ^ 1

        val stay = d + p
        if (stay < dis(i)(j)(nextK)) {
          dis(i)(j)(nextK) = stay
          pq.offer(Node(stay, i, j, nextK))
        }

        dirs.zipWithIndex.foreach { case ((dx, dy), idx) =>
          val x = i + dx
          val y = j + dy

          if (x >= 0 && x < m && y >= 0 && y < n) {

            val nd = d + (x + 1L) * (y + 1L) + (if ((idx % 2) != k) p.toLong else 0L)

            if (nd < dis(x)(y)(nextK)) {
              dis(x)(y)(nextK) = nd
              pq.offer(Node(nd, x, y, nextK))
            }
          }
        }
      }
    }

    -1L
  }
}
