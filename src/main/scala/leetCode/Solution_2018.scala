package leetCode

object Solution_2018 {
  def placeWordInCrossword(board: Array[Array[Char]], word: String): Boolean = {
    val transposedBoard = board.head.indices.map(c => board.map(_ (c))).toArray
    Seq(board, transposedBoard).exists(b => {
      Seq(word, word.reverse).exists(w => {
        b.exists(row => {
          row.mkString.split('#').exists(slot => {
            slot.length == w.length && slot.indices.forall(i => slot(i) == ' ' || slot(i) == w(i))
          })
        })
      })
    })
  }
}
