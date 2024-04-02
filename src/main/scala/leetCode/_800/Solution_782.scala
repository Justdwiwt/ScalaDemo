package leetCode._800

object Solution_782 {
  def movesToChessboard(board: Array[Array[Int]]): Int = {
    def half(x: Int): Boolean =
      x == board.length / 2 || x == (board.length + 1) / 2

    val vec = board.map(_.toVector)

    vec.toSet.toList match {
      case p1 :: p2 :: Nil if p1.zip(p2).forall(t => t._1 != t._2) && half(vec.count(_ == p1)) && half(p1.count(_ == 0)) =>
        val d = Seq(0, 1).maxBy(x => p1.count(_ == x))
        val p = Seq(p1, p2).maxBy(x => vec.count(_ == x))
        val col = p1.zipWithIndex.count { case (x, i) => (i % 2 == 0) ^ (x == d) }
        val row = vec.zipWithIndex.count { case (row, i) => (i % 2 == 0) ^ (row == p) }
        val res = Seq(col, row).map(x => if (board.length % 2 != 0) x else x.min(board.length - x)).sum / 2
        res
      case _ => -1
    }
  }
}
