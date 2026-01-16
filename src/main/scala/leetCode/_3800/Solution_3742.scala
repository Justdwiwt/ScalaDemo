package leetCode._3800

object Solution_3742 {
  def maxPathScore(grid: Array[Array[Int]], K: Int): Int = {
    val m = grid.length
    val n = grid.head.length
    val NEG = Int.MinValue / 4

    @inline def max(a: Int, b: Int): Int =
      if (a > b) a else b

    val f = Array.fill(m + 1, n + 1, K + 2)(NEG)

    (1 to K + 1).foreach(f(0)(1)(_) = 0)

    grid.indices.foreach(i =>
      grid(i).indices.foreach(j => {
        val x = grid(i)(j)
        (0 to K).foreach(k => {
          val nk = if (x == 0) k else k - 1
          if (nk >= 0) {
            val best = max(
              f(i)(j + 1)(nk + 1),
              f(i + 1)(j)(nk + 1)
            )
            if (best != NEG) f(i + 1)(j + 1)(k + 1) = best + x
          }
        })
      }))

    val ans = f(m)(n)(K + 1)
    if (ans < 0) -1 else ans
  }
}
