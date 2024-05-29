package leetCode._2600

import scala.collection.mutable.ArrayBuffer

object Solution_2523 {
  def closestPrimes(left: Int, right: Int): Array[Int] = {
    val primes = ArrayBuffer.empty[Int]
    val check = Array.fill(right + 1)(0)
    check(0) = 1
    check(1) = 1
    (2 to right).foreach(i => {
      if (check(i) == 0) primes += i
      var j = 1L * i * i
      while (j <= right) {
        check(j.toInt) = 1
        j += i
      }
    })
    var num = Int.MaxValue
    var res = Array(-1, -1)
    primes.indices.dropRight(1).foreach(i => if (primes(i) < left) ()
    else if (num > primes(i + 1) - primes(i)) {
      num = primes(i + 1) - primes(i)
      res = Array(primes(i), primes(i + 1))
    })
    res
  }
}
