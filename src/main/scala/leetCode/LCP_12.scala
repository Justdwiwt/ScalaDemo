package leetCode

object LCP_12 {
  def minTime(time: Array[Int], m: Int): Int = {
    var l = 0
    var r = 0
    r += time.sum
    while (l < r) {
      val t = l + r >> 1
      if (check(time, t, m)) r = t
      else l = t + 1
    }
    r
  }

  def check(a: Array[Int], t: Int, m: Int): Boolean = {
    var cnt = 1
    var ret = 1
    var mx = -1
    var flag = true
    var i = 0
    while (i < a.length) {
      mx = mx.max(a(i))
      if (ret >= a(i)) ret -= a(i)
      else if (flag) {
        flag = false
        ret += mx
        i -= 1
      }
      else {
        cnt += 1
        mx = -1
        flag = true
        ret = t
        i -= 1
      }
      i += 1
    }
    cnt <= m
  }
}
