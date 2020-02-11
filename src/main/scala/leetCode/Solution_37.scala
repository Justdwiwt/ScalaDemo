package leetCode

import scala.util.control.Breaks._

object Solution_37 {
  def solveSudoku(board: Array[Array[Char]]): Unit = func(board, 0, 0)

  def func(board: Array[Array[Char]], _i: Int, _j: Int): Boolean = {
    if (_i == 9) return true
    if (_j >= 9) return func(board, _i + 1, 0)
    if (board(_i)(_j) != '.') return func(board, _i, _j + 1)
    ('1' to '9').foreach(c => {
      breakable {
        if (!isValid(board, _i, _j, c)) break()
      }
      board(_i)(_j) = c
      if (func(board, _i, _j + 1)) return true
      board(_i)(_j) = '.'
    })
    false
  }

  def isValid(board: Array[Array[Char]], _i: Int, _j: Int, _v: Char): Boolean = {
    (0 until 9).foreach(x => if (board(x)(_j) == _v) return false)
    (0 until 9).foreach(y => if (board(_i)(y) == _v) return false)
    val row = _i - _i % 3
    val col = _j - _j % 3
    (0 until 3).foreach(x => (0 until 3).foreach(y => if (board(x + row)(y + col) == _v) return false))
    true
  }
}
