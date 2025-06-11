package leetCode._3600

object Solution_3561 {
  def resultingString(s: String): String = {
    @scala.annotation.tailrec
    def f(rem: List[Char], acc: List[Char]): List[Char] = {
      lazy val rh = rem.head
      lazy val ah = acc.head
      lazy val diff1 = ((rh - ah).abs == 1) || (rh.min(ah), rh.max(ah)) == ('a', 'z')
      if (rem.isEmpty) acc
      else if (acc.isEmpty || !diff1) f(rem.tail, rh +: acc)
      else f(rem.tail, acc.tail)
    }

    f(s.toList, Nil).reverse.mkString
  }
}
