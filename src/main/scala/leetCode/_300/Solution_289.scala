package leetCode._300

object Solution_289 {
  def gameOfLife(board: Array[Array[Int]]): Unit = board.indices./:(Array.fill(board.head.length)(0))((prevRow, i) => {
    val oldRow = board(i).clone
    board(i).indices./:(0)((prevCell, j) => {
      val cur = board(i)(j)
      val neighbours =
        prevRow.slice(j - 1, j + 2).sum +
          prevCell +
          (if (j < board(i).length - 1) board(i)(j + 1) else 0) +
          (if (i < board.length - 1) board(i + 1).slice(j - 1, j + 2).sum else 0)
      board(i)(j) = if ((neighbours | cur) == 3) 1 else 0
      cur
    })
    oldRow
  })
}
