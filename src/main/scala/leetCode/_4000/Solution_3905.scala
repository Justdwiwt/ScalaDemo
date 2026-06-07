package leetCode._4000

object Solution_3905 {
  def colorGrid(n: Int, m: Int, sources: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.fill(n, m)(0)
    sources.foreach { case Array(x, y, c) => res(x)(y) = c }

    val q = collection.mutable.Queue(sources.sortBy(-_(2)).map { case Array(x, y, c) => (x, y, c) }: _*)

    while (q.nonEmpty) {
      val (i, j, c) = q.dequeue()

      List(
        (i, j - 1),
        (i, j + 1),
        (i - 1, j),
        (i + 1, j)
      ).foreach {
        case (x, y) if x >= 0 && x < n && y >= 0 && y < m && res(x)(y) == 0 =>
          res(x)(y) = c
          q.enqueue((x, y, c))

        case _ =>
      }
    }

    res
  }
}
