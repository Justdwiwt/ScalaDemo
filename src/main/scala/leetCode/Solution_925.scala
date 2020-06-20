package leetCode

object Solution_925 {
  def isLongPressedName(name: String, typed: String): Boolean = {
    var l = 0
    var r = 0
    if (name(0) != typed(0)) return false
    while (l < name.length && r < typed.length) {
      if (name(l) == typed(r)) {
        l += 1
        r += 1
      } else if (name(l - 1) != typed(r)) return false
      else r += 1
    }
    if (l != name.length) return false
    l -= 1
    r -= 1
    while (r < typed.length) {
      if (typed(r) != name(l)) return false
      r += 1
    }
    true
  }
}
