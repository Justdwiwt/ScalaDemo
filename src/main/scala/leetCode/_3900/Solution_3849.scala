package leetCode._3900

object Solution_3849 {
  def maximumXor(s: String, t: String): String = {
    @scala.annotation.tailrec
    def f(s: List[Char], ones: Int, zeros: Int, acc: List[Char]): String = s match {
      case Nil => acc.reverse.mkString
      case h :: tail =>
        if ((h == '1' && zeros > 0) || (h == '0' && ones > 0)) {
          val (nOnes, nZeros) = if (h == '1') (ones, zeros - 1) else (ones - 1, zeros)
          f(tail, nOnes, nZeros, '1' :: acc)
        } else {
          val (nOnes, nZeros) = if (h == '1') (ones - 1, zeros) else (ones, zeros - 1)
          f(tail, nOnes, nZeros, '0' :: acc)
        }
    }

    val ones = t.count(_ == '1')
    f(s.toList, ones, s.length - ones, Nil)
  }
}
