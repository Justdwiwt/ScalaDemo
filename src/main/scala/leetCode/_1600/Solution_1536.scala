package leetCode._1600

object Solution_1536 {
  def minSwaps(grid: Array[Array[Int]]): Int = {
    lazy val x0 = grid.map(_.reverse.mkString).toList
    lazy val aMap = x0.map(s => s -> s.takeWhile(_ == '0').length).toMap
    lazy val canBeValid = x0.sorted.reverse.zipWithIndex.forall { case (s, i) => s.iterator.take(i).forall(_ == '0') }

    @scala.annotation.tailrec
    def g(seq1: Seq[String], step: Int, acc: Int): Int = {
      lazy val (d, t) = seq1.span(aMap(_) < step)
      if (step <= 0) acc else g(d ++ t.drop(1), step - 1, d.size + acc)
    }

    if (!canBeValid) -1 else g(x0, grid.length - 1, 0)
  }
}
