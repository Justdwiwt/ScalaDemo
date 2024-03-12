package leetCode.offer

object Offer_12 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {

    def dfs(y: Int, x: Int, pos: Int): Boolean =
      if (pos == word.length) true
      else if (y < 0 || y == board.length || x < 0 || x == board(0).length || board(y)(x) != word(pos)) false
      else {
        val char = board(y)(x)
        board(y)(x) = ' '
        val exist = dfs(y, x + 1, pos + 1) || dfs(y, x - 1, pos + 1) || dfs(y + 1, x, pos + 1) || dfs(y - 1, x, pos + 1)
        board(y)(x) = char
        exist
      }

    board.indices.foreach(y => board.head.indices.foreach(x => if (dfs(y, x, 0)) return true))
    false
  }
}
