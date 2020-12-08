package leetCode

object Solution_777 {
  def canTransform(start: String, end: String): Boolean = {
    var L = 0
    var R = 0
    start.indices.foreach(i => {
      if (start(i) == 'L') L -= 1
      else if (start(i) == 'R') {
        if (L > 0) return false
        R += 1
      }
      if (end(i) == 'L') {
        if (R > 0) return false
        L += 1
      } else if (end(i) == 'R') R -= 1
      if (L < 0 || R < 0 || L > 0 && R > 0) return false
    })
    L == 0 && R == 0
  }
}
