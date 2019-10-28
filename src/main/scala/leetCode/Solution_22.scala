package leetCode

object Solution_22 {
  def generateParenthesis(n: Int): List[String] = {
    var res = List[String]()
    if (n == 0) res = "" :: res
    else (0 until n).foreach(c =>
      generateParenthesis(c).foreach(left =>
        generateParenthesis(n - 1 - c).foreach(right =>
          res = ("(" + left + ")" + right) :: res)))
    res
  }
}
