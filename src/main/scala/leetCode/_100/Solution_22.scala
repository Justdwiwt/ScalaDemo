package leetCode._100

object Solution_22 {
  def generateParenthesis(n: Int): List[String] = n match {
    case 0 => List("")
    case n => (0 until n)
      .toList
      .flatMap(m => generateParenthesis(m)
        .flatMap(x => generateParenthesis(n - 1 - m)
          .map("(" ++ x ++ ")" ++ _)))
  }
}
