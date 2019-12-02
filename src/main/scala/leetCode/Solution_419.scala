package leetCode

object Solution_419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    if (board.isEmpty || board(0).isEmpty) return 0
    var res = 0
    board.indices.foreach(i => board(0).indices.foreach(j =>
      if (board(i)(j) == 'X')
        if ((i == 0 && (j == 0 || (j > 0 && board(i)(j - 1) != 'X'))) || (i > 0 && board(i - 1)(j) != 'X') && (j == 0 || j > 0 && board(i)(j - 1) != 'X'))
          res += 1
    ))
    res
  }
}
