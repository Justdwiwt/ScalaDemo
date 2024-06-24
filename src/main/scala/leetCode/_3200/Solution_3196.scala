package leetCode._3200

object Solution_3196 {
  def maximumTotalCost(a: Array[Int]): Long =
    a.reverse.foldLeft((0L, 0L)) { case ((f0, f1), ai) =>
      val newF0 = f1 + ai
      val newF1 = (f1 + ai).max(f0 - ai)
      (newF0, newF1)
    }._1
}
