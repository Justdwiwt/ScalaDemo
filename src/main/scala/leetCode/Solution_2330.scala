package leetCode

object Solution_2330 {
  def makePalindrome(s: String): Boolean = {
    var cnt = 0
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s(i) != s(j)) cnt += 1
      i += 1
      j -= 1
    }
    cnt <= 2
  }
}
