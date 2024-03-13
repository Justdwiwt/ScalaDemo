package leetCode._2500

object Solution_2485 {
  def pivotInteger(n: Int): Int = (1 to n)
    .find(f => (0 to f).sum == (f to n).sum)
    .getOrElse(-1)
}
