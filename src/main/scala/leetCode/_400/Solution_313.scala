package leetCode._400

object Solution_313 {
  def nthSuperUglyNumber(n: Int, primes: Array[Int]): Int = {
    val ugly = Array.fill(n + 1)(0L)
    ugly(0) = 1
    val pointer = Array.fill(primes.length)(0)
    (1 until n).foreach(i => {
      var min: Long = Int.MaxValue
      var minIndex = 0
      primes.indices.foreach(j => if (ugly(pointer(j)) * primes(j) < min) {
        min = ugly(pointer(j)) * primes(j)
        minIndex = j
      } else if (ugly(pointer(j)) * primes(j) == min) pointer(j) += 1)
      ugly(i) = min
      pointer(minIndex) += 1
    })
    ugly(n - 1).toInt
  }
}
