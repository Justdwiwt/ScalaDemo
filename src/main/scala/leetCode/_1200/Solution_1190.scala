package leetCode._1200

object Solution_1190 {
  def reverseParentheses(s: String): String = {
    def f(i: Int): (IndexedSeq[Range], Int) = (i until s.length).find(i => s(i) == '(' || s(i) == ')') match {
      case Some(j) if s(j) == '(' => f(j + 1) match {
        case (ranges1, k) => f(k) match {
          case (ranges2, k) => (ranges1.reverse.map(_.reverse).++(ranges2).+:(i until j), k)
        }
      }

      case Some(j) => (IndexedSeq(i until j), j + 1)

      case _ => (IndexedSeq(i until s.length), s.length)
    }

    f(0)._1.iterator.flatMap(_.map(s)).mkString
  }
}
