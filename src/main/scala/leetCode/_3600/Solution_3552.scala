package leetCode._3600

object Solution_3552 {
  def minMoves(matrix: Array[String]): Int = {
    val m = matrix.length
    val n = matrix.head.length

    val dist = Array.fill(m, n)(Int.MaxValue)

    val portals = Array.fill(26)(collection.mutable.ArrayBuffer.empty[(Int, Int)])
    val used = Array.fill(26)(false)

    matrix.indices.foreach(i => matrix.head.indices
      .map { j => val c = matrix(i)(j); (j, c) }
      .withFilter { case (_, c) => c >= 'A' && c <= 'Z' }
      .foreach { case (j, c) => portals(c - 'A') += ((i, j)) })

    val dx = Array(0, 0, 1, -1)
    val dy = Array(1, -1, 0, 0)

    dist(0)(0) = 0

    implicit val ord: Ordering[(Int, Int, Int)] = Ordering.by(_._1)
    val pq = collection.mutable.PriorityQueue.empty[(Int, Int, Int)](ord.reverse)
    pq.enqueue((0, 0, 0))

    while (pq.nonEmpty) {
      val (d, x, y) = pq.dequeue()

      if (dist(x)(y) < d) ()
      else if (x == m - 1 && y == n - 1) return d
      else {
        val c = matrix(x)(y)
        if (c >= 'A' && c <= 'Z') {
          val id = c - 'A'
          if (!used(id)) {
            used(id) = true
            portals(id).foreach { case (px, py) => if (px != x || py != y)
              if (dist(px)(py) > d) {
                dist(px)(py) = d
                pq.enqueue((d, px, py))
              }
            }
          }
        }

        dx.indices.foreach(i => {
          val nx = x + dx(i)
          val ny = y + dy(i)

          if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix(nx)(ny) != '#') {
            val nd = d + 1
            if (dist(nx)(ny) > nd) {
              dist(nx)(ny) = nd
              pq.enqueue((nd, nx, ny))
            }
          }
        })
      }
    }
    -1
  }
}
