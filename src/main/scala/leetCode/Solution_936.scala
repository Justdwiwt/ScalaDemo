package leetCode

object Solution_936 {
  def movesToStamp(stamp: String, target: String): Array[Int] = {
    val c = 'X'
    var s = target
    val f = target.map(_ => c)
    val rep = stamp.map(_ => c)
    var n = 0
    var ans = Array[Int]()
    val mx = s.length - stamp.length
    while (true) {
      var found = false
      (0 to mx).foreach(x => {
        val sub = s.substring(x, x + stamp.length)
        if (isstamp(stamp, sub, c)) {
          found = true
          s = s.substring(0, x) + rep + s.substring(x + stamp.length)
          ans :+= x
        }
      })
      n += 1
      if (n == 10 * target.length || !found) {
        if (s == f) return ans.reverse
        else return Array[Int]()
      }
    }
    Array[Int]()
  }

  def isstamp(stamp: String, cdt: String, c: Char): Boolean = {
    if (cdt == stamp.map(_ => c)) return false
    stamp.indices.withFilter(x => cdt(x) != stamp(x) && cdt(x) != c).foreach(_ => return false)
    true
  }
}
