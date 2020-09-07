package leetCode

object Solution_483 {
  def smallestGoodBase(n: String): String = {
    val N = n.toLong
    var res = N - 1

    def calc(e: Int, m: Long): Long = {
      var res = 1L
      var accE = e.toLong
      (0L until m).foreach(_ => {
        res += accE
        accE *= e
        if (res > N) return N + 1
      })
      if (res < N) return N - 1
      N
    }

    var m = 2L
    var flag = true
    while (m <= 72 && flag) {
      var l = 2.max(math.ceil(math.pow(N, 1 / (0.0 + m + 1))).toInt)
      var r = math.pow(N - 1, 1 / (0.0 + m)).toInt
      var mid = -1
      if (r == 1) flag = false
      if (l <= r) {
        if (calc(l, m) == N) res = res.min(l)
        while (l <= r) {
          if (r - l <= 1)
            if (calc(r, m) == N) {
              res = res.min(r)
              l += 1
              r -= 1
            }
            else {
              l += 1
              r -= 1
            }
          else {
            mid = l + (r - l) / 2
            val c = calc(mid, m)
            if (c >= N) r = mid
            else if (c < N) l = mid
          }
        }
      }
      m += 1
    }
    res.toString
  }
}
