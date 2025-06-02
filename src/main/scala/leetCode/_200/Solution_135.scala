package leetCode._200

object Solution_135 {
  def candy(ratings: Array[Int]): Int =
    if (ratings.isEmpty) 0
    else {
      val first = ratings.head
      val res = ratings.foldLeft[(Int, (Int, Int), Int)]((0, (0, 0), first))(sum)
      res._1 + cnt(res._2)
    }

  private def sum(data: (Int, (Int, Int), Int), rate: Int): (Int, (Int, Int), Int) = data match {
    case (res, pattern, pre) if pre < rate => pattern match {
      case (n, 0) => (res, (n + 1, 0), rate)
      case _ => (res + cnt(pattern), (1, 0), rate)
    }
    case (res, pattern, pre) if pre > rate => pattern match {
      case (n, 0) => (res, (n, 1), rate)
      case (l, r) => (res, (l, r + 1), rate)
    }
    case (res, pattern, _) => (res + cnt(pattern), (0, 1), rate)
  }

  private def cnt(pattern: (Int, Int)): Int = pattern match {
    case (n, 0) => (n + 2) * (n + 1) / 2 - 1
    case (0, m) => (m + 1) * m / 2
    case (n, m) if n > m => ((n + 2) * (n + 1) + m * (m + 1)) / 2 - 1
    case (n, m) => (n * (n + 1) + (m + 2) * (m + 1)) / 2 - 1
  }
}
