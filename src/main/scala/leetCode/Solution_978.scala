package leetCode

object Solution_978 {
  def maxTurbulenceSize(A: Array[Int]): Int = {
    var preLen = 1
    var res = 1
    var pre = '='
    (1 until A.length).foreach(i => {
      if (A(i) == A(i - 1)) {
        preLen = 1
        pre = '='
      } else if (A(i) > A(i - 1) && pre == '<' || A(i) < A(i - 1) && pre == '>') preLen += 1
      else preLen = 2
      pre = if (A(i) > A(i - 1)) '>' else '<'
      res = res.max(preLen)
    })
    res
  }
}
