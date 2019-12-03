package leetCode

object Solution_762 {
  def countPrimeSetBits(L: Int, R: Int): Int = (L to R).count(primeOnes)

  def primeOnes(n: Int): Boolean = isPrime(cnt(n, 0))

  @scala.annotation.tailrec
  def cnt(n: Int, acc: Int): Int = {
    if (n == 0) acc
    else n % 2 match {
      case 1 => cnt(n / 2, acc + 1)
      case 0 => cnt(n / 2, acc)
    }
  }

  def isPrime(n: Int): Boolean = {
    val s = Set(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    s.contains(n)
  }
}
