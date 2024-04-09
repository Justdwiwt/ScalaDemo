package leetCode._100

object Solution_37 {
  def solveSudoku(board: Array[Array[Char]]): Unit =
    SudokuState.from(board).solved().dropWhile(!_.finished).head.fill(board)

  case class SudokuState(nonEmpty: Map[(Int, Int), Char], empty: Set[(Int, Int)]) {
    private def row(r: Int) =
      (0 to 8).view.collect { case c if nonEmpty.contains((r, c)) => nonEmpty((r, c)) }

    private def col(c: Int) =
      (0 to 8).view.collect { case r if nonEmpty.contains((r, c)) => nonEmpty((r, c)) }

    private def quad(row: Int, col: Int) = (row * 3 to row * 3 + 2)
      .view
      .flatMap(r => (col * 3 to col * 3 + 2)
        .view
        .withFilter(c => nonEmpty.contains((r, c)))
        .map(c => nonEmpty((r, c)))
      )

    lazy val finished: Boolean = empty.isEmpty && !corrupted

    private def getOptions(coord: (Int, Int)): Set[Char] = {
      val (y, x) = coord
      Set('1' to '9': _*).diff(row(y).toSet.union(col(x).toSet).union(quad(y / 3, x / 3).toSet))
    }

    private lazy val allCandidates: Set[((Int, Int), Set[Char])] =
      empty.map(c => (c, getOptions(c)))

    private lazy val singleCandidates: Set[((Int, Int), Char)] =
      allCandidates.collect { case (c, s) if s.size == 1 => (c, s.head) }

    private def checkRow(r: Int): Boolean =
      row(r).groupBy(identity).exists(_._2.size != 1)

    private def checkCol(c: Int): Boolean =
      col(c).groupBy(identity).exists(_._2.size != 1)

    def checkQuad(r: Int, c: Int): Boolean =
      quad(r, c).groupBy(identity).exists(_._2.size != 1)

    private lazy val corrupted: Boolean =
      allCandidates.exists(_._2.isEmpty) || (0 to 8).exists(checkRow) || (0 to 8).exists(checkCol)

    private def next: SudokuState = {
      val candidates: Set[((Int, Int), Char)] = singleCandidates
      SudokuState(nonEmpty ++ candidates.toMap, empty.diff(candidates.map(_._1)))
    }

    private def branches: (SudokuState, List[SudokuState]) = {
      @scala.annotation.tailrec
      def loop(current: SudokuState): SudokuState =
        if (current.finished) current
        else if (current.singleCandidates.isEmpty) current
        else loop(current.next)

      val next = loop(this)
      val (coord, vs) = next.allCandidates.toList.minBy(_._2.size)
      (next, vs.map(v => next.update(coord, v)).toList)
    }

    def update(coord: (Int, Int), c: Char): SudokuState =
      SudokuState(nonEmpty.updated(coord, c), empty - coord)

    def fill(board: Array[Array[Char]]): Unit =
      nonEmpty.foreach { case ((y, x), c) => board(y)(x) = c }

    def solved(current: SudokuState = this, branches: List[SudokuState] = List.empty): Stream[SudokuState] = {
      if (current.finished) current #:: Stream.empty
      else if (current.singleCandidates.nonEmpty) current #:: solved(current.next, branches)
      else if (current.corrupted) current #:: solved(branches.head, branches.tail)
      else {
        val ps = current.branches._2
        current #:: solved(ps.head, ps.tail ++ branches)
      }
    }

    def string: String = s"Sudoku: ${nonEmpty.size} / ${empty.size}\n" +
      (0 to 8).map(row => (0 to 8).map(col =>
        if (nonEmpty.contains((row, col))) nonEmpty((row, col))
        else '_').sliding(3, 3).map(_.toList.mkString).mkString("  ")).mkString("\n")
  }

  private object SudokuState {
    def from(arr: Array[Array[Char]]): SudokuState = {
      val (nonEmpty, empty) = (0 to 8)
        .flatMap(r => (0 to 8).map(c => ((r, c), arr(r)(c))))
        .partition { case (_, v) => v != '.' }
      SudokuState(nonEmpty.toMap, empty.map(_._1).toSet)
    }
  }
}
