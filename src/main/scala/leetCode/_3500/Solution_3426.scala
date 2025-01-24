package leetCode._3500

object Solution_3426 {
  val M = 1000000007

  private def precomputeFactorials(limit: Int): (Array[BigInt], Array[BigInt]) = {
    val fact = Array.fill[BigInt](limit + 1)(BigInt(1))
    val invFact = Array.fill[BigInt](limit + 1)(BigInt(1))
    (2 to limit).foreach(i => fact(i) = fact(i - 1) * i % M)
    invFact(limit) = fact(limit).modInverse(M)
    (limit - 1 to 1 by -1).foreach(i => invFact(i) = invFact(i + 1) * (i + 1) % M)
    (fact, invFact)
  }

  private def comb(n: Int, k: Int, fact: Array[BigInt], invFact: Array[BigInt]): Int = {
    if (k > n || k < 0) return 0
    val res = fact(n) * invFact(k) % M * invFact(n - k) % M
    res.toInt
  }

  def distanceSum(m: Int, n: Int, k: Int): Int = {
    val limit = math.max(m * n, math.max(n + 1, m + 1))
    val (fact, invFact) = precomputeFactorials(limit)
    val combMN_2 = comb(m * n - 2, k - 2, fact, invFact)
    val combN1_3 = comb(n + 1, 3, fact, invFact)
    val combM1_3 = comb(m + 1, 3, fact, invFact)
    val part1 = (BigInt(combMN_2) * (m.toLong * m.toLong * combN1_3 + n.toLong * n.toLong * combM1_3)) % M
    (part1.toInt + M) % M
  }
}
