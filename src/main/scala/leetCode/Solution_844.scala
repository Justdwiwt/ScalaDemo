package leetCode

object Solution_844 {
  def backspaceCompare(S: String, T: String): Boolean = {
    func(S, "") == func(T, "")
  }

  @scala.annotation.tailrec
  def func(str: String, acc: String): String = str match {
    case "" => acc
    case str: String if str.head == '#' => if (acc != "") func(str.tail, acc.tail) else func(str.tail, acc)
    case _ => func(str.tail, str.head + acc)
  }
}
