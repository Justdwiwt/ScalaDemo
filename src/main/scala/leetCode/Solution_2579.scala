package leetCode

object Solution_2579 {
  def coloredCells(n: Int): Long =
    f(0, n, 1)

  @scala.annotation.tailrec
  private def f(partial: Int, steps: Int, acc: Long): Long =
    if (steps <= 1) acc
    else f(partial + 4, steps - 1, acc + partial + 4)
}
