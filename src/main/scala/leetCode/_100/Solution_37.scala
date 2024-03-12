package leetCode._100

object Solution_37 {
  def valid(board: Array[Array[Char]], row: Int, col: Int, c: Char): Boolean = {
    (0 until 9).foreach(i => {
      if (board(i)(col) == c || board(row)(i) == c) return false
      if (board(3 * (row / 3) + i / 3)(3 * (col / 3) + i % 3) == c) return false
    })
    true
  }

  def solve(board: Array[Array[Char]]): Boolean = {
    board.indices.foreach(i => board.head.indices.foreach(j => if (board(i)(j) == '.') {
      ('1' to '9').foreach(c => if (valid(board, i, j, c)) {
        board(i)(j) = c
        if (solve(board)) return true
        else board(i)(j) = '.'
      })
      return false
    }))
    true
  }

  def solveSudoku(board: Array[Array[Char]]): Unit =
    solve(board)
}
