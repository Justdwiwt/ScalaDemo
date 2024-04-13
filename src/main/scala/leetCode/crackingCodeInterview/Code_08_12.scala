package leetCode.crackingCodeInterview

import scala.collection.mutable.ListBuffer

object Code_08_12 {
  def solveNQueens(n: Int): List[List[String]] = {
    val queens = Array.fill(n)(-1)
    val res = ListBuffer.empty[List[String]]
    f(res, queens, n, 0, 0, 0, 0)
    res.toList
  }

  private def f(buffer: ListBuffer[List[String]], queens: Array[Int], n: Int, row: Int, columns: Int, diagonals1: Int, diagonals2: Int): Unit = {
    if (row == n) {
      val board = g(queens, n)
      buffer += board
    } else {
      var availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2))
      while (availablePositions != 0) {
        val position = availablePositions & (-availablePositions)
        availablePositions = availablePositions & (availablePositions - 1)
        val column = Integer.bitCount(position - 1)
        queens(row) = column
        f(buffer, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1)
        queens(row) = -1
      }
    }
  }

  private def g(queens: Array[Int], n: Int): List[String] = {
    val board = ListBuffer.empty[String]
    (0 until n).foreach(i => {
      val row = Array.fill[Char](n)('.')
      row(queens(i)) = 'Q'
      board += row.mkString
    })
    board.toList
  }
}
