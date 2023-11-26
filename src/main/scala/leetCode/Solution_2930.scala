package leetCode

object Solution_2930 {
  def stringCount(n: Int): Int = {
    if (n < 4) 0
    else {
      val M = 1000000007
      val total = BigInt("26").pow(n)
      val l0 = BigInt("25").pow(n)
      val t0 = BigInt("25").pow(n)
      val e01 = BigInt("25").pow(n) + BigInt("25").pow(n - 1) * BigInt(n.toString)
      val l0t0 = BigInt("24").pow(n)
      val l0e01 = BigInt("24").pow(n) + BigInt("24").pow(n - 1) * BigInt(n.toString)
      val t0e01 = BigInt("24").pow(n) + BigInt("24").pow(n - 1) * BigInt(n.toString)
      val l0t0e01 = BigInt("23").pow(n) + BigInt("23").pow(n - 1) * BigInt(n.toString)
      ((total - l0 - t0 - e01 + l0e01 + l0t0 + t0e01 - l0t0e01) % M).toInt
    }
  }
}
