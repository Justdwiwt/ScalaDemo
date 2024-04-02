package leetCode._800

object Solution_794 {
  def validTicTacToe(board: Array[String]): Boolean = {
    if (board.flatten.mkString.count(_ == 'X') != board.flatten.mkString.count(_ == 'O') &&
      board.flatten.mkString.count(_ == 'X') != (board.flatten.mkString.count(_ == 'O') + 1)) return false

    val xwin = if (board.contains("XXX")
      || board.map(_.charAt(0)).mkString == "XXX"
      || board.map(_.charAt(1)).mkString == "XXX"
      || board.map(_.charAt(2)).mkString == "XXX"
      || (board(0).charAt(0) == 'X' && board(1).charAt(1) == 'X' && board(2).charAt(2) == 'X')
      || (board(0).charAt(2) == 'X' && board(1).charAt(1) == 'X' && board(2).charAt(0) == 'X')
    ) true else false
    val owin = if (board.contains("OOO")
      || board.map(_.charAt(0)).mkString == "OOO"
      || board.map(_.charAt(1)).mkString == "OOO"
      || board.map(_.charAt(2)).mkString == "OOO"
      || (board(0).charAt(0) == 'O' && board(1).charAt(1) == 'O' && board(2).charAt(2) == 'O')
      || (board(0).charAt(2) == 'O' && board(1).charAt(1) == 'O' && board(2).charAt(0) == 'O')
    ) true else false
    if (xwin && owin) return false
    if (xwin && board.flatten.mkString.count(_ == 'X') == (board.flatten.mkString.count(_ == 'O') + 1)) return true
    if (owin && board.flatten.mkString.count(_ == 'X') == board.flatten.mkString.count(_ == 'O')) return true

    if (!xwin && !owin && (board.flatten.mkString.count(_ == 'X') == board.flatten.mkString.count(_ == 'O')
      || board.flatten.mkString.count(_ == 'X') == board.flatten.mkString.count(_ == 'O') + 1)) return true
    false
  }
}
