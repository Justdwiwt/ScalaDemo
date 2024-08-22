package leetCode._3300

object Solution_3256 {
  def maximumValueSum(board: Array[Array[Int]]): Long = {
    val boardSet = board.indices.toSet
    val boardHeadSet = board.head.indices.toSet

    def get(i: Int, j: Int): Long =
      board(i)(j).toLong

    def max(boardSet: Set[Int], boardHeadSet: Set[Int]): (Int, Int) = boardSet
      .flatMap(i => boardHeadSet.map((i, _)))
      .maxBy { case (i, j) => get(i, j) }

    def maxH(i: Int, js: Set[Int]): Int =
      js.maxBy(get(i, _))

    def maxV(is: Set[Int], j: Int): Int =
      is.maxBy(get(_, j))

    def maxHV(is: Set[Int], i: Int, js: Set[Int], j: Int): (Int, Int) =
      (maxV(is - i, j), maxH(i, js - j))

    val (ai, aj) = max(boardSet, boardHeadSet)
    val (bi, bj) = maxHV(boardSet, ai, boardHeadSet, aj)

    def g(is: Set[Int], js: Set[Int]): Long = {
      val (ai, aj) = max(is, js)
      val (bi, bj) = maxHV(is, ai, js, aj)
      val (ci, cj) = max(is - ai, js - aj)
      (get(ai, aj) + get(ci, cj)).max(get(ai, bj) + get(bi, aj))
    }

    def f(i: Int, j: Int): Long =
      get(i, j) + g(boardSet - i, boardHeadSet - j)

    f(ai, aj).max(f(ai, bj)).max(f(bi, aj)).max(f(bi, bj))
  }
}
