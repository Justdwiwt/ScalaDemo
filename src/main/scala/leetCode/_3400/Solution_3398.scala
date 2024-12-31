package leetCode._3400

object Solution_3398 {
  def minLength(s: String, numOps: Int): Int = {
    val n = s.length

    def f(x: Int): Boolean =
      (0 until n).count(i => s(i) % 2 != (i + x) % 2) <= numOps

    if (f(0) || f(1)) return 1

    def check(lim: Int): Boolean = {
      var cnt = 0
      var j = 0
      (0 until n).foreach(i => if (i == n - 1 || s(i) != s(i + 1)) {
        val len = i - j + 1
        cnt += len / (lim + 1)
        j = i + 1
      })
      cnt <= numOps
    }

    var (head, tail) = (2, n)
    while (head < tail) {
      val mid = (head + tail) / 2
      if (check(mid)) tail = mid
      else head = mid + 1
    }
    head
  }
}
