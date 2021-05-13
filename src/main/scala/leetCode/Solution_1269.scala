package leetCode

object Solution_1269 {
  def numWays(numSteps: Int, length: Int): Int =
    f(numSteps, 1 +: IndexedSeq.fill((length - 1).min(numSteps / 2))(0))

  @scala.annotation.tailrec
  def f(step: Int, cnt: IndexedSeq[Int]): Int =
    if (step == 0) cnt.head
    else f(step - 1, cnt
      .indices
      .map(i => {
        Traversable(cnt(i),
          Some(i - 1).filter(cnt.indices.contains).map(cnt).getOrElse(0),
          Some(i + 1).filter(cnt.indices.contains).map(cnt).getOrElse(0))
          .reduce((x, y) => (x + y) % 1000000007)
      }))
}
