package leetCode._3800

object Solution_3765 {
  private def isPrime(n: Int): Boolean =
    n >= 2 && (2 to math.sqrt(n).toInt).forall(n % _ != 0)

  def completePrime(num: Int): Boolean = {
    val s = num.toString
    s.indices.forall(i => isPrime(s.take(i + 1).toInt) && isPrime(s.drop(i).toInt))
  }
}
