package leetCode._1400

object Solution_1387 {
  private def f(x: Int): Int = {
    @scala.annotation.tailrec
    def g(x: Int, step: Int): Int = x match {
      case 1 => step
      case n => g(if (n % 2 == 0) n / 2 else n * 3 + 1, step + 1)
    }

    g(x, 0)
  }

  def getKth(lo: Int, hi: Int, k: Int): Int = (lo to hi)
    .map(n => (n, f(n)))
    .sortBy { case (_, pow) => pow }
    .toList(k - 1) match {
    case (n, _) => n
  }
}
