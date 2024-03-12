package leetCode._1300

object Solution_1275 {
  def tictactoe(moves: Array[Array[Int]]): String = {
    var a = 0
    var b = 0
    (moves.indices by 2).foreach(i => {
      a |= 1 << moves(i)(0) * 3 + moves(i)(1)
      if (i != moves.length - 1) b |= 1 << moves(i + 1)(0) * 3 + moves(i + 1)(1)
    })
    if (((~a) & 273) == 0 || ((~a) & 84) == 0) return "A"
    if (((~b) & 273) == 0 || ((~b) & 84) == 0) return "B"
    var rol = 7
    var col = 73
    (0 until 3).foreach(_ => {
      if (((~a) & rol) == 0 || ((~a) & col) == 0) return "A"
      if (((~b) & rol) == 0 || ((~b) & col) == 0) return "B"
      rol <<= 3
      col <<= 1
    })
    if (moves.length < 9) "Pending" else "Draw"
  }
}
