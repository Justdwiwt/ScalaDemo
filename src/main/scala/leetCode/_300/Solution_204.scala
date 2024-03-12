package leetCode._300

object Solution_204 {
  def countPrimes(n: Int): Int = {
    lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(i => ps.takeWhile(j => j * j <= i).forall(k => i % k > 0))
    ps.takeWhile(_ < n).size
  }
}
