package leetCode

object Solution_1249 {
  def removeIndices(string: String, stack: List[Int]): String = string
    .zipWithIndex
    .filter({ case (_, idx) => !stack.contains(idx) })
    .map({ case (x, _) => x })
    .mkString

  @scala.annotation.tailrec
  def f(string: List[(Char, Int)], stack: List[Int], store: List[Int], ori: String): String = string.headOption match {
    case None => removeIndices(ori, stack ++ store)
    case Some(('(', idx)) => f(string.tail, idx :: stack, store, ori)
    case Some((')', idx)) if stack.isEmpty => f(string.tail, stack, store :+ idx, ori)
    case Some((')', _)) if stack.nonEmpty && ori.charAt(stack.head) == '(' => f(string.tail, stack.tail, store, ori)
    case Some(_) => f(string.tail, stack, store, ori)
  }

  def minRemoveToMakeValid(s: String): String =
    f(s.zipWithIndex.toList, Nil, Nil, s)
}
