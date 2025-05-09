package leetCode._3600

object Solution_3535 {
  def queryConversions(conversions: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val M = BigInt(1000000007)

    val n = conversions.length + 1
    val parent = (0 until n).toArray
    val weight = Array.fill[BigInt](n)(BigInt(1))

    def inv(x: BigInt): BigInt =
      x.modPow(M - 2, M)

    def find(x: Int): Int = {
      if (parent(x) != x) {
        val p = parent(x)
        val r = find(p)
        weight(x) = (weight(x) * weight(p)) % M
        parent(x) = r
      }

      parent(x)
    }

    conversions
      .withFilter { case Array(u, v, wInt) => true; case _ => false }
      .foreach { case Array(u, v, wInt) =>
        val w = BigInt(wInt)
        val ru = find(u)
        val rv = find(v)
        if (ru != rv) {
          val w_u = weight(u)
          val w_v = weight(v)
          val w_ru = (w_v * inv(w_u) % M) * inv(w) % M
          parent(ru) = rv
          weight(ru) = w_ru
        }
      }

    queries.map { case Array(x, y) =>
      val rx = find(x)
      val ry = find(y)
      if (rx != ry) 0
      else {
        val ans = (weight(y) * inv(weight(x))) % M
        ans.toInt
      }
    }
  }
}
