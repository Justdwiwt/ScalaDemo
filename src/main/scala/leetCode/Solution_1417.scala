package leetCode

object Solution_1417 {
  def reformat(s: String): String = {
    var n1 = 0
    var n2 = 0
    val arr = s.toCharArray
    arr.foreach(i => if (check(i)) n1 += 1 else n2 += 1)
    if (n1 - n2 < -1 || n1 - n2 > 1) return ""
    if (n1 > n2) {
      n1 = 0
      n2 = 1
    } else {
      n1 = 1
      n2 = 0
    }
    s.toCharArray.foreach(i => {
      if (check(i)) {
        arr(n1) = i
        n1 += 2
      } else {
        arr(n2) = i
        n2 += 2
      }
    })

    arr.mkString
  }

  def check(c: Char): Boolean = c >= '0' && c <= '9'
}
