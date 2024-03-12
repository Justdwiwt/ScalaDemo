package leetCode.crackingCodeInterview

object Code_16_04 {
  def tictactoe(board: Array[String]): String = {
    val n = board.length
    var rows, cols, dig1, dig2 = 0
    var flag = false
    board.indices.foreach(i => {
      rows = 0
      cols = 0
      dig1 += board(i)(i)
      dig2 += board(i)(n - 1 - i)
      board.indices.foreach(j => {
        rows += board(i)(j)
        cols += board(j)(i)
        if (board(i)(j) == ' ') flag = true
      })
      if (rows == 'X' * n || cols == 'X' * n) return "X"
      else if (rows == 'O' * n || cols == 'O' * n) return "O"
    })
    if (dig1 == 'X' * n || dig2 == 'X' * n) return "X"
    if (dig1 == 'O' * n || dig2 == 'O' * n) return "O"
    if (flag) return "Pending"
    "Draw"
  }
}
