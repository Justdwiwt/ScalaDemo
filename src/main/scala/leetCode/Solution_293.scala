package leetCode

object Solution_293 {
  def generatePossibleNextMoves(s: String): List[String] = {
    var res = List.empty[String]
    (0 until s.length - 1).foreach(i => {
      if (s(i) == s(i + 1) && s(i) == '+') {
        val sb = new StringBuilder(s)
        if (s(i) == '+') {
          sb.setCharAt(i, '-')
          sb.setCharAt(i + 1, '-')
        }
        res ::= sb.toString()
      }
    })
    res
  }
}
