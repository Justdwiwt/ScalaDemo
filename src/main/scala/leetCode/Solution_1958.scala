package leetCode

object Solution_1958 {
  val dirs: Array[Array[Int]] = Array[Array[Int]](Array(-1, -1), Array(-1, 0), Array(-1, 1), Array(0, 1), Array(1, 1), Array(1, 0), Array(1, -1), Array(0, -1))

  def checkMove(board: Array[Array[Char]], rMove: Int, cMove: Int, color: Char): Boolean = {
    var m = 0
    var n = 0

    def g(i: Int, j: Int): Boolean = i >= 0 && i < m && j >= 0 && j < n

    def f(board: Array[Array[Char]], rMove: Int, cMove: Int, rSign: Int, cSign: Int, color: Char, opColor: Char): Boolean = {
      var r = rMove + rSign
      var c = cMove + cSign
      if (g(r, c) && board(r)(c) == opColor) {
        while (g(r, c) && board(r)(c) == opColor) {
          r += rSign
          c += cSign
        }
        if (g(r, c) && board(r)(c) == color) return true
      }
      false
    }

    m = board.length
    n = board.head.length

    val opColor = if (color == 'W') 'B' else 'W'
    dirs.foreach(dir => if (f(board, rMove, cMove, dir(0), dir(1), color, opColor)) return true)

    false
  }
}
