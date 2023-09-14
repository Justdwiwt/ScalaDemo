package leetCode

object Solution_2850 {
  private val ones = Vector.fill(9)(1)

  def minimumMoves(grid: Array[Array[Int]]): Int =
    f(Seq(grid.head.toVector ++ grid(1) ++ grid(2)), Set.empty, 0)

  @scala.annotation.tailrec
  private def f(states: Seq[Vector[Int]], seen: Set[Vector[Int]], moves: Int): Int =
    if (states.contains(ones)) moves
    else {
      val nSeen = seen ++ states
      val nStates = states.flatMap(g).distinct.filter(!nSeen.contains(_))
      f(nStates, nSeen, moves + 1)
    }

  private def g(state: Vector[Int]): Seq[Vector[Int]] = state.indices.flatMap(i => {
    if (state(i) <= 1) Seq.empty
    else {
      val rem = state.updated(i, state(i) - 1)

      def add(bool: Boolean, to: Int): Seq[Vector[Int]] =
        if (bool) Seq(rem.updated(to, rem(to) + 1))
        else Seq.empty

      add(i >= 3, i - 3) ++ add(i % 3 != 2, i + 1) ++ add(i < 6, i + 3) ++ add(i % 3 != 0, i - 1)
    }
  })
}
