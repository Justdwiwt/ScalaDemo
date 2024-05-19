package leetCode._1600

object Solution_1535 {
  def getWinner(arr: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(h0: Int, it: Iterator[Int], rem: Int): Int =
      if (rem == 0 || !it.hasNext) h0 else {
        lazy val h1 = it.next()
        lazy val (_, mx) = if (h0 < h1) (h0, h1) else (h1, h0)
        f(mx, it, if (mx == h0) rem - 1 else k - 1)
      }

    if (k > arr.length) arr.max else f(arr.head, arr.iterator.drop(1), k)
  }
}
