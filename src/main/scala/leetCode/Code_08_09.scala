package leetCode

object Code_08_09 {
  def generateParenthesis(n: Int): List[String] = {
    var res = List.empty[String]

    def func(l: Int, r: Int, a: String): Unit = {
      if (l == 0 && r == 0) {
        res :+= a
        return
      }
      if (l != 0) func(l - 1, r, a + '(')
      if (l < r) func(l, r - 1, a + ')')
    }

    func(n, n, "")
    res
  }
}
