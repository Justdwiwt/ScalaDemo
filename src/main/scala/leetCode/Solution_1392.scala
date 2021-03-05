package leetCode

object Solution_1392 {
  def longestPrefix(s: String): String = {
    var curr = 0
    val mx = Array.fill(s.length)(0)
    s.indices.drop(1).foreach(i => {
      while (curr > 0 && s(i) != s(curr)) curr = mx(curr - 1)
      if (s(i) == s(curr)) curr += 1
      mx(i) = curr
    })
    s.substring(0, curr)
  }
}
