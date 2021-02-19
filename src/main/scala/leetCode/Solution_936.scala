package leetCode

object Solution_936 {
  def movesToStamp(stamp: String, target: String): Array[Int] = {
    val ch = 'X'
    var s = target
    val f = target.map(_ => ch)
    val rep = stamp.map(_ => ch)
    var cnt = 0
    var res = Array.emptyIntArray
    val mx = s.length - stamp.length
    while (true) {
      var flag = false
      (0 to mx).foreach(idx => {
        val sub = s.substring(idx, idx + stamp.length)
        if (check(stamp, sub, ch)) {
          flag = true
          s = s.substring(0, idx) + rep + s.substring(idx + stamp.length)
          res :+= idx
        }
      })
      cnt += 1
      if (cnt == 10 * target.length || !flag)
        if (s == f) return res.reverse
        else return Array.emptyIntArray
    }
    Array.emptyIntArray
  }

  def check(s1: String, s2: String, ch: Char): Boolean = {
    if (s2 == s1.map(_ => ch)) return false
    s1.indices.withFilter(x => s2(x) != s1(x) && s2(x) != ch).foreach(_ => return false)
    true
  }
}
