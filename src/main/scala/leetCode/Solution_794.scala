package leetCode

object Solution_794 {
  def validTicTacToe(board: Array[String]): Boolean = {
    var t = 0
    val r = Array.fill(3)(0)
    val c = Array.fill(3)(0)
    var d1 = 0
    var d2 = 0
    (0 until 3).foreach(i => (0 until 3).foreach(j => {
      val n = board(i)(j) match {
        case 'X' => 1
        case 'O' => -1
        case _ => 0
      }
      t += n
      r(i) += n
      c(j) += n
      if (i == j) d1 += n
      if (i + j == 2) d2 += n
    }))
    val z = r ++ c ++ Array(d1, d2)
    if (z.contains(3) && t != 1) return false
    if (z.contains(-3) && t != 0) return false
    t == 0 || t == 1
  }
}
