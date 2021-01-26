package leetCode

object Solution_1021 {
  def removeOuterParentheses(S: String): String = S./:((0, ""))((acc, ch) => acc match {
    case (0, s) if ch == '(' => (1, s)
    case (1, s) if ch == ')' => (0, s)
    case (x, s) if ch == '(' => (x + 1, s + ch)
    case (x, s) if ch == ')' => (x - 1, s + ch)
  })._2
}
