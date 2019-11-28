package leetCode

object Solution_36 {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    var parts = List[List[Char]]()
    (0 until 9).foreach(i => parts ::= board(i).toList)
    (0 until 9).foreach(j => {
      var tmp = List[Char]()
      (0 until 9).foreach(i => tmp ::= board(i)(j))
      parts ::= tmp
    })
    val tmp = List((0, 0), (3, 0), (6, 0), (0, 3), (0, 6), (3, 3), (3, 6), (6, 3), (6, 6))
    tmp.foreach(i => {
      var tmp = List[Char]()
      (0 until 3).foreach(j => (0 until 3).foreach(k => tmp ::= board(i._1 + j)(i._2 + k)))
      parts ::= tmp
    })
    parts.map(i => i.filter(_ != '.')).forall(valid)
  }

  def valid(list: List[Char]): Boolean = list.length == list.distinct.length
}
