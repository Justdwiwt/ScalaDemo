package leetCode._100

object Solution_51 {
  def solveNQueens(n: Int): List[List[String]] = {
    def diagCk(ite: Iterator[Int]): Boolean = ite.
      zipWithIndex
      .map { case (i, x) => i - x }
      .toSeq
      .distinct
      .length == n

    (0 until n)
      .permutations
      .filter(arr => diagCk(arr.iterator) && diagCk(arr.reverseIterator))
      .map(_.iterator.map(("." * n).updated(_, 'Q')).toList)
      .toList
  }
}
