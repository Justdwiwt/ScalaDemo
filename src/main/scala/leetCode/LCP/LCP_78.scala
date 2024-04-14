package leetCode.LCP

object LCP_78 {
  def rampartDefensiveLine(rampart: Array[Array[Int]]): Int = Iterator
    .iterate((0, rampart.last.head - rampart.head(1))) { case (left, right) =>
      val mid = (left + right + 1) >> 1
      if (check(mid, rampart)) (mid, right)
      else (left, mid - 1)
    }
    .dropWhile { case (left, right) => left < right }
    .next()
    ._2

  private def check(mid: Int, rampart: Array[Array[Int]]): Boolean = {
    val (_, isValid) = rampart.indices.drop(1).dropRight(1).foldLeft(rampart(1).head - rampart.head(1), true) { case ((pre, isValid), i) =>
      val last = rampart(i + 1).head - rampart(i)(1)
      if (!isValid || pre + last < mid) (pre, false)
      else if (mid <= pre) (last, isValid)
      else (pre + last - mid, isValid)
    }
    isValid
  }
}
