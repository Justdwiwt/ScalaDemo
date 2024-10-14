package leetCode._900

object Solution_887 {
  def superEggDrop(K: Int, N: Int): Int = {
    var left = 1
    var right = N
    while (left < right) {
      val mid = left + (right - left) / 2
      if (f(mid, K, N) < N) left = mid + 1
      else right = mid
    }
    right
  }

  private def f(x: Int, k: Int, n: Int): Int = {
    @scala.annotation.tailrec
    def loop(i: Int, res: Int, r: Int): Int =
      if (i > k || res >= n) res
      else {
        val newR = r * (x - i + 1) / i
        val newRes = res + newR
        loop(i + 1, newRes, newR)
      }

    loop(1, 0, 1)
  }
}
