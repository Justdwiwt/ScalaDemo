package leetCode._3200

object Solution_3189 {
  def minMoves(rooks: Array[Array[Int]]): Int = {
    val sortedByFirst = rooks.sortBy(_.head)
    val sumFirst = sortedByFirst.zipWithIndex.map { case (rook, i) => (i - rook.head).abs }.sum

    val sortedBySecond = rooks.sortBy(_(1))
    val sumSecond = sortedBySecond.zipWithIndex.map { case (rook, i) => (i - rook(1)).abs }.sum

    sumFirst + sumSecond
  }
}
