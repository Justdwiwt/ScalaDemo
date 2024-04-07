package leetCode._300

object Solution_275 {
  def hIndex(citations: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int): Int =
      if (l < r) {
        val mid = (l + r) >>> 1
        if (citations(citations.length - mid - 1) >= mid + 1) f(mid + 1, r)
        else f(l, mid)
      } else l

    f(0, citations.length)
  }
}
