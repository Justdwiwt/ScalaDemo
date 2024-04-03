package leetCode._700

object Solution_668 {
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    @scala.annotation.tailrec
    def f(left: Int, right: Int): Int =
      if (left >= right) left
      else {
        val mid = (left + right) >>> 1
        if ((1 to m).map(i => n.min(mid / i)).sum >= k) f(left, mid)
        else f(mid + 1, right)
      }

    f(1, m * n)
  }
}
