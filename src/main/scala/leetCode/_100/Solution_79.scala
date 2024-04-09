package leetCode._100

object Solution_79 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    lazy val wordSeq = word.toList

    def f(x: Int, y: Int, s: Seq[Char], visited: Set[(Int, Int)]): Boolean =
      if (s.isEmpty) true
      else if (visited.contains((x, y)) || x < 0 || y < 0 || x >= board.length || y >= board.head.length || s.head != board(x)(y)) false
      else Seq((1, 0), (-1, 0), (0, 1), (0, -1)).exists { case (a, b) => f(x + a, y + b, s.tail, visited + ((x, y))) }

    board.indices.exists(x => board.head.indices.exists(f(x, _, wordSeq, Set())))
  }
}
