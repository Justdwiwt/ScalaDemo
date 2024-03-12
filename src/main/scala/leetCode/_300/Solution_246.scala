package leetCode._300

object Solution_246 {
  def isStrobogrammatic(num: String): Boolean = {
    val diff = Map(
      '0' -> '0',
      '1' -> '1',
      '6' -> '9',
      '8' -> '8',
      '9' -> '6'
    )
    var l = 0
    var r = num.length - 1
    var c1, c2 = ' '
    while (l <= r) {
      c1 = num(l)
      if (!diff.contains(c1)) return false
      c1 = diff(c1)
      c2 = num(r)
      if (c1 != c2) return false
      l += 1
      r -= 1
    }
    true
  }
}
