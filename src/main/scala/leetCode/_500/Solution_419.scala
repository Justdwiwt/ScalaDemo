package leetCode._500

object Solution_419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    @scala.annotation.tailrec
    def f(row: Int, column: Int, sameBattleship: Boolean, returnValue: Int): Int =
      if (row >= board.length) returnValue
      else if (column >= board(row).length) f(row + 1, 0, sameBattleship = false, returnValue)
      else (board(row)(column), sameBattleship, if (row == 0) None else Some(board(row - 1)(column))) match {
        case ('.', _, _) => f(row, column + 1, sameBattleship = false, returnValue)
        case ('X', true, _) => f(row, column + 1, sameBattleship = true, returnValue)
        case ('X', false, Some('X')) => f(row, column + 1, sameBattleship = false, returnValue)
        case ('X', false, _) => f(row, column + 1, sameBattleship = true, returnValue + 1)
      }

    f(0, 0, sameBattleship = false, 0)
  }
}
