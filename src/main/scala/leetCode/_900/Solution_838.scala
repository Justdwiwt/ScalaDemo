package leetCode._900

object Solution_838 {
  def pushDominoes(dominoes: String): String = {
    val res = ("L" + dominoes + "R").toCharArray
    val len = res.length
    var idx = 1
    while (idx < len) {
      if (res(idx) == '.') {
        var j = idx
        while (res(j + 1) == '.') j += 1
        if (res(idx - 1) == 'R' && res(j + 1) == 'R')
          (idx to j).foreach(k => res(k) = 'R')
        else if (res(idx - 1) == 'L' && res(j + 1) == 'L')
          (idx to j).foreach(k => res(k) = 'L')
        else if (res(idx - 1) == 'R' && res(j + 1) == 'L') {
          var a = idx
          var b = j
          while (a < b) {
            res(a) = 'R'
            res(b) = 'L'
            a += 1
            b -= 1
          }
        }
        idx = j
      }
      idx += 1
    }
    res.mkString.substring(1, len - 1)
  }
}
