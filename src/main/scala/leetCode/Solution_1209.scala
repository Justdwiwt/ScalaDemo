package leetCode

object Solution_1209 {
  def removeDuplicates(s: String, k: Int): String = s./:(List.empty[(Char, Int)]) { case (l, c) =>
    l match {
      case (x, i) :: _ =>
        if (x == c && i + 1 == k) l.drop(i)
        else if (x == c) (c, i + 1) :: l
        else (c, 1) :: l
      case Nil => (c, 1) :: l
    }
  }.map(_._1).mkString("").reverse
}
