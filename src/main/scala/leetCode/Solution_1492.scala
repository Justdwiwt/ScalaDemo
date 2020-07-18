package leetCode

object Solution_1492 {
  def kthFactor(n: Int, k: Int): Int = {
    val l = (1 to n).filter(i => n % i == 0)
    if (k > l.length) -1 else l(k - 1)
  }
}
