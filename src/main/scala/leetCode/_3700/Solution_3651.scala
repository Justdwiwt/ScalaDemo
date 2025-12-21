package leetCode._3700

object Solution_3651 {
  def minCost(grid: Array[Array[Int]], k: Int): Int = {
    val n = grid.head.length
    val mx = grid.map(_.max).max
    val INF = Long.MaxValue / 4

    def min(a: Long, b: Long) =
      if (b < a) b else a

    @scala.annotation.tailrec
    def loop(times: Int, suf: Array[Long], lastF: Array[Long]): Long = {
      if (times == 0) lastF(n)
      else {
        val minF = Array.fill(mx + 1)(INF)

        val f = Array.fill(n + 1)(INF)
        f(1) = -grid(0)(0)

        grid.foreach(row => {
          var j = 0
          while (j < n) {
            val x = row(j)
            val v = min(min(f(j), f(j + 1)) + x, suf(x))
            f(j + 1) = v
            minF(x) = min(minF(x), v)
            j += 1
          }
        })

        val newSuf = suf.clone()
        var i = mx
        while (i >= 0) {
          newSuf(i) = min(newSuf(i + 1), minF(i))
          i -= 1
        }

        if (newSuf.sameElements(suf)) f(n)
        else loop(times - 1, newSuf, f)
      }
    }

    val suf0 = Array.fill(mx + 2)(INF)
    loop(k + 1, suf0, Array.fill(n + 1)(INF)).toInt
  }
}
