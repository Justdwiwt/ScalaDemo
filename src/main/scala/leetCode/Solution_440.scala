package leetCode

object Solution_440 {
  def findKthNumber(n: Int, k: Int): Int = {
    @scala.annotation.tailrec
    def f(x: Int, y: Int, acc: Int): Int = if (x <= n) f(10 * x, 10 * y, acc + (n + 1).min(y) - x) else acc

    @scala.annotation.tailrec
    def g(k: Int, acc: Int): Int = k match {
      case 0 => acc
      case _ => f(acc, acc + 1, 0) match {
        case count if k >= count => g(k - count, acc + 1)
        case count if k < count => g(k - 1, acc * 10)
      }
    }

    g(k - 1, 1)
  }
}
