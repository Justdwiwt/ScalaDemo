package leetCode

object Solution_1881 {
  def maxValue(n: String, x: Int): String = {
    lazy val ch = x.toString.toSeq.head

    @scala.annotation.tailrec
    def f(cmp: (Char, Char) => Boolean)(s: Seq[Char], acc: Seq[Char]): Seq[Char] =
      if (s.isEmpty) (ch +: acc).reverse
      else if (cmp(ch, s.head)) (ch +: acc).reverse ++ s
      else f(cmp)(s.tail, s.head +: acc)

    (if (n.head == '-') f(_ < _)(n.toList.tail, List('-')) else f(_ > _)(n.toList, List())).mkString
  }
}
