package leetCode._100

object Solution_52 {
  def totalNQueens(n: Int): Int = {
    def nQueens(k: Int): List[List[Int]] =
      if (k == 0) List(Nil)
      else nQueens(k - 1).flatMap(q => (0 until n).withFilter(c => isValid(c, q)).map(c => c :: q))

    def isValid(col: Int, queens: List[Int]) =
      (1 to queens.length).zip(queens).forall({ case (r, c) => c != col && r != (col - c).abs })

    nQueens(n).length
  }
}
