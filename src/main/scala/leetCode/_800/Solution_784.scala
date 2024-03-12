package leetCode._800

object Solution_784 {
  def letterCasePermutation(S: String): List[String] = f(S.toList, "")

  def f(S: List[Char], acc: String): List[String] = S match {
    case Nil => List(acc.reverse)
    case h :: t if h.isLetter => f(t, h.toUpper + acc) ::: f(t, h.toLower + acc)
    case h :: t => f(t, h + acc)
  }
}
