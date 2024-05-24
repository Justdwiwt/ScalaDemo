package leetCode._3000

object Solution_2911 {
  private var chars: Array[Char] = _
  private var dps: Array[Array[Int]] = _
  private var checks: Array[Array[Int]] = _

  def minimumChanges(s: String, k: Int): Int = {
    chars = s.toCharArray
    val n = chars.length
    dps = Array.ofDim[Int](n, k + 1)
    checks = Array.ofDim[Int](n, n)
    dp(0, k) - k
  }

  private def checkD(head: Int, tail: Int, d: Int): Int = {
    val length = tail - head + 1
    var res = 0
    (0 until d).foreach(x => {
      var left = head + x
      var right = left + length - d
      while (left < right) {
        if (chars(left) != chars(right)) res += 1
        left += d
        right -= d
      }
    })
    res
  }

  private def check(head: Int, tail: Int): Int = {
    if (checks(head)(tail) > 0) return checks(head)(tail)
    val length = tail - head + 1
    val sq = math.sqrt(length).toInt
    var best = checkD(head, tail, 1)
    (2 to sq).foreach(d => if (length % d > 0) ()
    else {
      best = best.min(checkD(head, tail, d))
      best = best.min(checkD(head, tail, length / d))
    })
    checks(head)(tail) = best + 1
    checks(head)(tail)
  }

  private def dp(head: Int, k: Int): Int = {
    if (k == 1) return check(head, chars.length - 1)
    if (dps(head)(k) > 0) return dps(head)(k)
    val end = chars.length - (k - 1) * 2
    var best = Int.MaxValue
    (head + 1 until end).foreach(tail => {
      val res = check(head, tail) + dp(tail + 1, k - 1)
      best = best.min(res)
    })
    dps(head)(k) = best
    dps(head)(k)
  }
}
