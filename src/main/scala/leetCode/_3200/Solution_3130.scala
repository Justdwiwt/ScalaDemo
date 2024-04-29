package leetCode._3200

object Solution_3130 {
  def numberOfStableArrays(zero: Int, one: Int, limit: Int): Int = {
    val M = 1000000007
    val arr = Array.ofDim[Int](zero + 1, one + 1, 2)

    (1 to limit.min(zero)).foreach(i => arr(i)(0)(0) = 1)

    (1 to limit.min(one)).foreach(j => arr(0)(j)(1) = 1)

    (1 to zero).foreach(i => (1 to one).foreach(j => {
      arr(i)(j)(0) = ((arr(i - 1)(j)(0).toLong + arr(i - 1)(j)(1) + (if (i > limit) M - arr(i - limit - 1)(j)(1) else 0)) % M).toInt
      arr(i)(j)(1) = ((arr(i)(j - 1)(0).toLong + arr(i)(j - 1)(1) + (if (j > limit) M - arr(i)(j - limit - 1)(0) else 0)) % M).toInt
    })
    )

    (arr(zero)(one).head + arr(zero)(one)(1)) % M
  }
}
