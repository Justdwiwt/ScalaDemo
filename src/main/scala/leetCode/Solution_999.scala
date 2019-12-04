package leetCode

object Solution_999 {
  def numRookCaptures(board: Array[Array[Char]]): Int = {
    if (board.isEmpty || board(0).isEmpty) return 0
    var res = 0
    val start = find(board)
    val offset = Array((1, 0), (-1, 0), (0, -1), (0, 1))
    offset.foreach(i => {
      var V = (start._1 + i._1, start._2 + i._2)
      while (inbound(V, board))
        if (board(V._1)(V._2) == '.') V = (V._1 + i._1, V._2 + i._2)
        else if (board(V._1)(V._2) == 'B') V = (-1, -1)
        else {
          res += 1
          V = (-1, -1)
        }
    })
    res
  }

  def inbound(V: (Int, Int), board: Array[Array[Char]]): Boolean = V._1 >= 0 && V._2 >= 0 && V._1 < board.length && V._2 < board(0).length

  def find(board: Array[Array[Char]]): (Int, Int) = {
    board.indices.foreach(i => board(i).indices.foreach(j => if (board(i)(j) == 'R') return (i, j)))
    (-1, -1)
  }
}
