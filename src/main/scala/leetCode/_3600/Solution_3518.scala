package leetCode._3600

object Solution_3518 {
  def smallestPalindrome(s: String, k: Int): String = {
    def comb(n: Long, m: Long): Long = {
      val choose = math.min(m, n - m)
      var res = 1L
      var i = 1L
      while (i <= choose && res <= k) {
        res = res * (n - i + 1) / i
        if (res > k) res = k + 1L
        i += 1
      }
      res
    }

    def perms(rem: Int, cnt: Array[Int]): Long = {
      var ways = 1L
      var remain = rem
      var i = 0
      while (i < 26 && ways <= k) {
        if (cnt(i) > 0) {
          ways *= comb(remain, cnt(i))
          remain -= cnt(i)
        }
        i += 1
      }
      ways
    }

    val half = s.length / 2
    val cnt = Array.fill(26)(0)
    s.take(half).foreach(c => cnt(c - 'a') += 1)

    val left = new StringBuilder
    var rank = 1L

    (0 until half).foreach(pos => {
      val pick = (0 until 26).find { c =>
        if (cnt(c) == 0) false
        else {
          cnt(c) -= 1
          val ways = perms(half - pos - 1, cnt)
          val ok = rank + ways > k
          if (!ok) {
            rank += ways
            cnt(c) += 1
          }
          ok
        }
      }

      pick.foreach(c => left += (c + 'a').toChar)
    })

    if (left.length != half) ""
    else {
      val first = left.toString
      val mid =
        if ((s.length & 1) == 1) s(half).toString
        else ""
      first + mid + first.reverse
    }
  }
}
