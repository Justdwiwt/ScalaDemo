package leetCode._500

object Solution_420 {
  def strongPasswordChecker(s: String): Int = {
    val pq = new java.util.PriorityQueue[Int]((a: Int, b: Int) => a % 3 - b % 3)
    if (s.isEmpty) return 6
    var need1 = 1
    var need2 = 1
    var need3 = 1
    var cnt = 1
    var len = s.length
    if (s.head.isLower) need1 = 0
    if (s.head.isUpper) need2 = 0
    if (s.head.isDigit) need3 = 0
    (1 until len).foreach(i => {
      if (s(i).isLower) need1 = 0
      if (s(i).isUpper) need2 = 0
      if (s(i).isDigit) need3 = 0
      if (s(i) != s(i - 1)) {
        if (cnt >= 3) pq.add(cnt)
        cnt = 1
      } else cnt += 1
    })
    if (cnt >= 3) pq.add(cnt)
    val need = need1 + need2 + need3
    var res = 0
    if (len < 6) {
      if (len == 5) {
        if (need >= 2 || cnt == 5) return need
        return 1
      } else return 6 - len
    }
    while (!pq.isEmpty && len > 20) {
      var now = pq.poll()
      res += 1
      len -= 1
      now -= 1
      if (now >= 3) pq.add(now)
    }
    if (len > 20) res += len - 20 + 0.max(need)
    else {
      var cunt = 0
      while (!pq.isEmpty) {
        val now = pq.poll()
        cunt += now / 3
      }
      res += cunt.max(need)
    }
    res
  }
}
