package leetCode._4000

object Solution_3918 {
  def sumOfPrimesInRange(n: Int): Int = {
    val r = n.toString.reverse.toInt
    val (l, h) = (n.min(r), n.max(r))

    (l max 2 to h)
      .filter(isPrime)
      .sum
  }

  private def isPrime(x: Int): Boolean =
    x >= 2 && Iterator.from(2).takeWhile(d => d.toLong * d <= x).forall(x % _ != 0)
}
