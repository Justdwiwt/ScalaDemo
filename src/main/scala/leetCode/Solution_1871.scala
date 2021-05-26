package leetCode

object Solution_1871 {
  def canReach(s: String, minJump: Int, maxJump: Int): Boolean = {
    var l = minJump
    var r = maxJump
    s.indices.foreach(i => {
      if (s(i) == '0' && l <= i && i <= r) {
        if (i == s.length - 1) return true
        if (i >= r) l = i + minJump
        r = i + maxJump
      }
    })
    false
  }
}
