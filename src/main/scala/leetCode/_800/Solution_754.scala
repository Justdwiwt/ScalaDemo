package leetCode._800

object Solution_754 {
  def reachNumber(target: Int): Int = {
    f(0, target.abs, 1)
  }

  @scala.annotation.tailrec
  private def f(sum: Int, target: Int, step: Int): Int =
    if (sum >= target && (sum - target) % 2 == 0) step - 1
    else f(sum + step, target, step + 1)
}
