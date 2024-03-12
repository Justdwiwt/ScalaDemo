package leetCode._3100

object Solution_3006 {
  def beautifulIndices(s: String, a: String, b: String, k: Int): List[Int] = {
    @scala.annotation.tailrec
    def f(i: Int, res: List[Int]): List[Int] = {
      val ia = s.indexOf(a, i)
      val ib = s.indexOf(b, 0.max(ia - k))
      (ia, ib) match {
        case (-1, _) => res
        case (_, -1) => res
        case (ia, ib) if (ia - ib).abs <= k => f(ia + 1, ia :: res)
        case (ia, _) => f(ia + 1, res)
      }
    }

    f(0, Nil).reverse
  }
}
