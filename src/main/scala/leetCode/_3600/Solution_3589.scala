package leetCode._3600

object Solution_3589 {
  def primeSubarray(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    if (n == 0) return 0
    val maxV = nums.max
    val isPrime = Array.fill(maxV + 1)(true)
    if (maxV >= 0) isPrime(0) = false
    if (maxV >= 1) isPrime(1) = false
    var p = 2
    while (p * p <= maxV) {
      if (isPrime(p)) {
        var m0 = p * p
        while (m0 <= maxV) {
          isPrime(m0) = false
          m0 += p
        }
      }
      p += 1
    }
    val primes = nums.zipWithIndex.collect { case (v, i) if v <= maxV && isPrime(v) => (i, v) }
    val m = primes.length
    if (m < 2) return 0
    val pp = primes.map(_._1)
    val pv = primes.map(_._2)
    val A = new Array[Long](m)
    val B = new Array[Long](m)
    primes.indices.foreach(i => {
      val pos = pp(i)
      val prev = if (i > 0) pp(i - 1) else -1
      A(i) = pos - prev
      val next = if (i < m - 1) pp(i + 1) else n
      B(i) = next - pos
    })
    val prefixA = new Array[Long](m)
    prefixA(0) = A(0)
    primes.indices.drop(1).foreach(i => prefixA(i) = prefixA(i - 1) + A(i))
    val maxD = new java.util.ArrayDeque[Int]()
    val minD = new java.util.ArrayDeque[Int]()
    var l0 = 0
    var res = 0L
    primes.indices.foreach(j => {
      while (!maxD.isEmpty && pv(maxD.peekLast) < pv(j)) maxD.removeLast()
      maxD.addLast(j)
      while (!minD.isEmpty && pv(minD.peekLast) > pv(j)) minD.removeLast()
      minD.addLast(j)
      while (!maxD.isEmpty && !minD.isEmpty && pv(maxD.peekFirst) - pv(minD.peekFirst) > k) {
        if (maxD.peekFirst == l0) maxD.removeFirst()
        if (minD.peekFirst == l0) minD.removeFirst()
        l0 += 1
      }
      if (j > l0) {
        val sumA = prefixA(j - 1) - (if (l0 > 0) prefixA(l0 - 1) else 0L)
        res += sumA * B(j)
      }
    })
    res.toInt
  }
}
