package leetCode._3900

object Solution_3855 {
  private val MOD = 1000000007L

  @scala.annotation.tailrec
  private def modPow(b: Long, e: Long, acc: Long = 1L): Long =
    if (e == 0) acc
    else if ((e & 1) == 1) modPow(b * b % MOD, e >> 1, acc * b % MOD)
    else modPow(b * b % MOD, e >> 1, acc)

  private def inv(x: Long): Long = modPow(x, MOD - 2)

  def sumOfNumbers(l: Int, r: Int, k: Int): Int = {
    val m = r - l + 1L
    val res =
      ((l + r) % MOD) *
        modPow(m, k) % MOD *
        ((modPow(10, k) - 1 + MOD) % MOD) % MOD *
        inv(18) % MOD

    res.toInt
  }
}
