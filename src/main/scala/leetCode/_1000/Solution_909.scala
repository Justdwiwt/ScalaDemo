package leetCode._1000

object Solution_909 {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    lazy val b = 1 +: board
      .reverseIterator
      .zipWithIndex
      .flatMap { case (a, i) => if (i % 2 != 0) a.toList.reverse else a.toList }
      .toVector

    lazy val n2 = board.length * board.length

    @scala.annotation.tailrec
    def f(q: collection.immutable.Queue[(Int, Int)], visited: Set[Int]): Int = {
      lazy val ((x: Int, step: Int), q1: collection.immutable.Queue[(Int, Int)]) = q.dequeue
      lazy val newSquares: List[(Int, Int)] = (1 to 6.min(n2 - x))
        .map(a => (if (b(x + a) > 0) b(x + a) else x + a) -> (step + 1))
        .filterNot { case (y, _) => (y > n2) || visited.contains(y) }
        .toList

      if (q.isEmpty) -1
      else if (x == n2) step
      else f(q1 ++ newSquares, visited ++ newSquares.map(_._1))
    }

    f(collection.immutable.Queue((1, 0)), Set(1))
  }
}
