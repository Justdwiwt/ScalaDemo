package leetCode._700

object Solution_670 {
  def maximumSwap(num: Int): Int = f(g(num))./:(0)(_ * 10 + _)

  def g(num: Int): Seq[Int] = (if (num > 9) g(num / 10) else Seq.empty[Int]) :+ (num % 10)

  def f(n: Seq[Int]): Seq[Int] = {
    val mx = n.max
    n.indexWhere(_ != mx) match {
      case 0 =>
        val lastIdx = n.lastIndexOf(mx)
        (mx +: n.slice(1, lastIdx) :+ n.head) ++ n.drop(lastIdx + 1)
      case -1 => n
      case mxIdx => n.take(mxIdx) ++ f(n.drop(mxIdx))
    }
  }
}
