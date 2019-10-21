package leetCode

object Solution_1021 {
  def removeOuterParentheses(S: String): String = {
    var cnt = 0
    var res = ""
    (0 until S.length).foreach(i => {
      if ('(' == S(i)) {
        cnt += 1
        if (cnt > 1) res += S(i)
      }
      if (')' == S(i)) {
        cnt -= 1
        if (cnt >= 1) res += S(i)
      }
    })
    res
  }
}
