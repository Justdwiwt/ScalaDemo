package leetCode._1500

object Solution_1434 {
  def numberWays(hats: List[List[Int]]): Int = {
    val M = (1e9 + 7).toInt
    val dp = Array.ofDim[Int](41, 1 << 10)
    val has = Array.ofDim[Boolean](10, 41)
    hats.indices.foreach(i => hats(i).foreach(j => has(i)(j) = true))
    dp(0)(0) = 1
    (1 to 40).foreach(i => (0 until (1 << hats.length)).foreach(j => {
      dp(i)(j) += dp(i - 1)(j)
      dp(i)(j) %= M
      hats.indices.foreach(k => {
        val t = if ((j & (1 << k)) > 0) true else false
        if (t && has(k)(i)) {
          dp(i)(j) += dp(i - 1)(j - (1 << k))
          dp(i)(j) %= M
        }
      })
    }))
    dp(40)((1 << hats.length) - 1)
  }
}

object SafeCal {
  private val zero = 0.toLong
  private val mod = 1e9.toLong + 7

  def getMod(x: Long, flag: Boolean = true): Long =
    if (flag) x % mod else x

  def sum(seq: Seq[Int], flag: Boolean = true): Int =
    getMod(seq./:(zero)((acc, x) => acc + x.toLong), flag).toInt

  def mul(x: Int, y: Int, flag: Boolean = true): Int =
    getMod(x.toLong * y.toLong, flag).toInt

  def add(x: Int, y: Int, flag: Boolean = true): Int =
    getMod(x.toLong + y.toLong, flag).toInt
}

object Math {
  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int =
    if (x % y == 0) y else gcd(y, x % y)

  def lcm(x: Int, y: Int): Int =
    x / gcd(x, y) * y

  def hasBitK(x: Int, k: Int): Boolean =
    (x & (1 << k)) != 0
}

object Solution {
  def numberWays(hats: List[List[Int]]): Int = {
    val dp = Array.fill(1 << hats.length)(0)
    val hatsID = hats.flatten.distinct.toArray
    dp(0) = 1
    hats
      .flatten
      .distinct
      .indices
      .foreach(i => ((1 << hats.length) - 1 to 1 by (-1))
        .foreach(state => dp(state) = SafeCal.add(dp(state), SafeCal.sum(hats
          .indices
          .withFilter(Math.hasBitK(state, _))
          .withFilter(hats(_).contains(hatsID(i)))
          .map(k => dp(state - (1 << k))))))
      )
    dp.last
  }
}
