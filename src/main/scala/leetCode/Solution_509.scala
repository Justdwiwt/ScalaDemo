package leetCode

object Solution_509 {
  def fib(N: Int): Int = N match {
    case 0 => 0
    case _ => (1 until N)./:(0, 1) { case (f, _) => (f._2, f._1 + f._2) }._2
  }
}
