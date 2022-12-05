package leetCode

object Solution_999 {
  def numRookCaptures(board: Array[Array[Char]]): Int = {
    val (row, col) = rookPosition(board)
    val directions = Array((-1, 0), (0, +1), (+1, 0), (0, -1))
    directions.map(pawnsHitThisDirection(row, col, board, _)).sum
  }

  private def rookPosition(board: Array[Array[Char]]): (Int, Int) = {
    (0 until 8)
      .foreach(row => (0 until 8)
        .foreach(col => if (board(row)(col) == 'R') return (row, col)))
    throw new IllegalArgumentException("Rook not found on board")
  }

  @scala.annotation.tailrec
  private def pawnsHitThisDirection(row: Int, col: Int, board: Array[Array[Char]], direction: (Int, Int)): Int = {
    if (outOfBoard(col, row) || board(row)(col) == 'B') return 0
    if (board(row)(col) == 'p') return 1
    pawnsHitThisDirection(row + direction._1, col + direction._2, board, direction)
  }

  private def outOfBoard(col: Int, row: Int): Boolean =
    col < 0 || col > 7 || row < 0 || row > 7
}
