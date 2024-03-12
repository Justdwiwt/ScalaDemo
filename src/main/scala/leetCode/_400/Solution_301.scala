package leetCode._400

object Solution_301 {
  def removeInvalidParentheses(s: String): List[String] = {
    def f(input: String, left: Int, right: Int, prev: String): List[String] = input match {
      case "" => if (left == right) List(prev) else Nil
      case s: String if s.startsWith("(") =>
        f(input.drop(1), left, right, prev) ++ f(input.drop(1), left + 1, right, prev + "(")
      case s: String if s.startsWith(")") =>
        if (right >= left) f(input.drop(1), left, right, prev)
        else f(input.drop(1), left, right, prev) ++ f(input.drop(1), left, right + 1, prev + ")")
      case _ => f(input.drop(1), left, right, prev + input.take(1))
    }

    val output = f(s, 0, 0, "")
    val mn = output.map(_.length).max
    output.filter(_.length == mn).distinct
  }
}
