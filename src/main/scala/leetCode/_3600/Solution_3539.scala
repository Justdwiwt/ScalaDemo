package leetCode._3600

object Solution_3539 {
  val M: BigInt = BigInt(1000000007)
  val MX: Int = 31

  val fac: Array[BigInt] = Array.fill(MX)(BigInt(1))
  val invF: Array[BigInt] = Array.fill(MX)(BigInt(1))

  {
    (1 until MX).foreach(i => fac(i) = (fac(i - 1) * i) % M)
    invF(MX - 1) = fac(MX - 1).modPow(M - 2, M)
    ((MX - 2) to 0 by -1).foreach(i => invF(i) = (invF(i + 1) * (i + 1)) % M)
  }

  def magicalSum(m: Int, k: Int, nums: Array[Int]): Int = {
    val n = nums.length
    val powV: Array[Array[BigInt]] = Array.fill(n, m + 1)(BigInt(1))
    nums.indices.foreach(i => (1 to m).foreach(j => powV(i)(j) = (powV(i)(j - 1) * nums(i)) % M))

    val cache = collection.mutable.Map[(Int, Int, BigInt, Int), BigInt]()

    def dfs(i: Int, leftM: Int, x: BigInt, leftK: Int): BigInt = {
      val c1 = x.bitCount
      if (c1 + leftM < leftK) return BigInt(0)
      if (i == n || leftM == 0 || leftK == 0) {
        return if (leftM == 0 && c1 == leftK) BigInt(1) else BigInt(0)
      }

      cache.getOrElseUpdate((i, leftM, x, leftK), {
        var res = BigInt(0)
        (0 to leftM).foreach(j => {
          val bit = ((x + j) & 1).toInt
          val r = dfs(i + 1, leftM - j, (x + j) >> 1, leftK - bit)
          res = (res + r * powV(i)(j) % M * invF(j) % M) % M
        })
        res
      })
    }

    (dfs(0, m, BigInt(0), k) * fac(m) % M).toInt
  }
}
