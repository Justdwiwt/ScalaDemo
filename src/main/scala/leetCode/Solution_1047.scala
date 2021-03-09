package leetCode

object Solution_1047 {
  def removeDuplicates(S: String): String = S./:(Nil: List[Char])((a, x) => (a, x) match {
    case (Nil, _) => List(x)
    case (y :: ys, c) => if (y == c) ys else c :: a
  }).reverse.mkString
}
