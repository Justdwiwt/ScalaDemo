package leetCode

object Solution_36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = (0 until 9)
    .flatMap(i => (0 until 9).withFilter(j => board(i)(j) != '.').map(j => (i, j, j / 3 + ((i / 3) * 3))))
    .groupBy(p => board(p._1)(p._2))
    .valuesIterator
    .forall(g => g.unzip3.productIterator.asInstanceOf[Iterator[Vector[Int]]].forall(_.groupBy(identity).values.forall(_.size == 1)))
}
