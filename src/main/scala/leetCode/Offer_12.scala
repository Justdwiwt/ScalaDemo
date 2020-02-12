package leetCode

object Offer_12 {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    if (board == null || board.isEmpty || board(0).isEmpty || word == null || word.isEmpty) return true
    board.indices.foreach(r => board(0).indices.foreach(c => if (board(r)(c) == word(0)) if (f(board, word, r, c, 0)) return true))
    false
  }

  def f(board: Array[Array[Char]], word: String, r: Int, c: Int, start: Int): Boolean = {
    if (start == word.length) return true
    if (!g(board, r, c) || board(r)(c) != word(start)) return false
    board(r)(c) = '#'
    val res = f(board, word, r + 1, c, start + 1) ||
      f(board, word, r, c + 1, start + 1) ||
      f(board, word, r - 1, c, start + 1) ||
      f(board, word, r, c - 1, start + 1)
    board(r)(c) = word(start)
    res
  }

  def g(board: Array[Array[Char]], r: Int, c: Int): Boolean = r >= 0 && r < board.length && c >= 0 && c < board(0).length
}
