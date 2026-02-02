package leetCode._3800

object Solution_3797 {
  def numberOfRoutes(grid: Array[String], d: Int): Int = {
    val M = 1000000007
    val m = grid.head.length

    @inline def min(a: Int, b: Int): Int = if (b < a) b else a

    @inline def max(a: Int, b: Int): Int = if (b > a) b else a

    @inline def norm(x: Int): Int = if (x < 0) x + M else if (x >= M) x - M else x

    val (_, finalFG) = grid.indices.foldLeft((Array.fill(m + 1)(0), Array.fill(m + 1)(0))) { case ((prevF, prevFG), i) =>
      val row = grid(i)

      val curF = grid.head.indices.foldLeft(Array(0))((acc, j) => {
        val v =
          if (row(j) == '#') acc.last
          else if (i == 0) acc.last + 1
          else {
            val l = max(j - d + 1, 0)
            val r = min(j + d, m)
            acc.last + prevFG(r) - prevFG(l)
          }
        acc :+ norm(v)
      })

      val curFG = grid.head.indices.foldLeft(Array(0))((acc, j) => {
        val v =
          if (row(j) == '#') acc.last
          else {
            val l = max(j - d, 0)
            val r = min(j + d + 1, m)
            acc.last + curF(r) - curF(l)
          }
        acc :+ norm(v)
      })

      (curF, curFG)
    }

    finalFG(m)
  }
}
