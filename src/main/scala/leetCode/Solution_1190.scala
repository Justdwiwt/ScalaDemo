package leetCode

object Solution_1190 {
  def reverseParentheses(s: String): String = {
    var start = List.empty[List[Char]]
    var mid = List.empty[Char]
    s.foreach(ch => if (ch == '(') {
      if (mid.nonEmpty) {
        start = mid.reverse :: start
        mid = List.empty[Char]
      }
      start = List('(') :: start
    } else if (ch == ')') {
      start = start.tail
      if (start.nonEmpty && start.head.head != '(') {
        mid = start.head ::: mid
        start = start.tail
      }
      mid = mid.reverse
    } else mid = ch :: mid)
    if (start.nonEmpty) (start.head ::: mid.reverse).mkString else mid.reverse.mkString
  }
}
