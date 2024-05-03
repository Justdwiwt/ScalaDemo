package leetCode._400

object Solution_348 {
  class TicTacToe(n: Int) {
    private val rows: Array[Array[Int]] = Array.ofDim[Int](3, n)
    private val columns: Array[Array[Int]] = Array.ofDim[Int](3, n)
    private val diagonals: Array[Array[Int]] = Array.ofDim[Int](3, 2)

    def move(row: Int, col: Int, player: Int): Int = {
      rows(player)(row) += 1
      if (rows(player)(row) == n) return player

      columns(player)(col) += 1
      if (columns(player)(col) == n) return player

      if (row == col) {
        diagonals(player)(0) += 1
        if (diagonals(player)(0) == n) return player
      }

      if (row + col == n - 1) {
        diagonals(player)(1) += 1
        if (diagonals(player)(1) == n) return player
      }

      0
    }
  }
}
