package leetCode._3500

object Solution_3428 {
  private val M = 1000000007L
  private val MX = 100000

  private val F = Array.fill(MX)(0L)
  private val INV_F = Array.fill(MX)(0L)

  {
    F(0) = 1
    (1 until MX).foreach(i => F(i) = (F(i - 1) * i) % M)

    INV_F(MX - 1) = pow(F(MX - 1), M - 2)
    (MX - 2 to 0 by -1).foreach(i => INV_F(i) = (INV_F(i + 1) * (i + 1)) % M)
  }

  private def pow(base: Long, exp: Long): Long = {
    @scala.annotation.tailrec
    def f(b: Long, e: Long, acc: Long): Long =
      if (e == 0) acc
      else if (e % 2 == 1) f(b * b % M, e / 2, acc * b % M)
      else f(b * b % M, e / 2, acc)

    f(base % M, exp, 1)
  }

  private def comb(n: Int, m: Int): Long =
    if (m < 0 || m > n) 0
    else (F(n) * INV_F(m) % M * INV_F(n - m) % M) % M

  def minMaxSums(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val sorted = nums.sorted
    nums.indices.foldLeft((0L, 1L)) { case ((ans, s), i) =>
      val newAns = (ans + s * (sorted(i).toLong + sorted(n - 1 - i).toLong)) % M
      val newS = (s * 2 - comb(i, k - 1) + M) % M
      (newAns, newS)
    }._1.toInt
  }
}
