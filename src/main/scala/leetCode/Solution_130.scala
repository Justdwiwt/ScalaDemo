package leetCode

object Solution_130 {
  def solve(board: Array[Array[Char]]): Unit =
    if (board.nonEmpty) {
      def f(i: Int, j: Int): Unit = {
        board(i)(j) = 'm'
        if (i > 0 && board(i - 1)(j) == 'O') f(i - 1, j)
        if (i < board.length - 1 && board(i + 1)(j) == 'O') f(i + 1, j)
        if (j > 0 && board(i)(j - 1) == 'O') f(i, j - 1)
        if (j < board(i).length - 1 && board(i)(j + 1) == 'O') f(i, j + 1)
      }

      board.indices.foreach(i => {
        if (board(i).head == 'O') f(i, 0)
        val lInd = board(i).length - 1
        if (board(i)(lInd) == 'O') f(i, lInd)
      })
      board.head.indices.foreach(j => {
        if (board.head(j) == 'O') f(0, j)
        val lInd = board.length - 1
        if (board(lInd)(j) == 'O') f(lInd, j)
      })

      board.indices.foreach(i => board(i).indices.foreach(j => if (board(i)(j) == 'O') board(i)(j) = 'X' else if (board(i)(j) == 'm') board(i)(j) = 'O'))
    }
}
