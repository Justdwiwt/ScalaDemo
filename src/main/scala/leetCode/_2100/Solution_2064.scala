package leetCode._2100

object Solution_2064 {
  def minimizedMaximum(n: Int, quantities: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int): Int = {
      if (l >= r) l
      else {
        val mid = (l + r) >>> 1
        if (quantities./:(0)((sum, q) => sum + (q + mid - 1) / mid) > n)
          f(mid + 1, r)
        else f(l, mid)
      }
    }

    f(1, quantities.max)
  }
}
