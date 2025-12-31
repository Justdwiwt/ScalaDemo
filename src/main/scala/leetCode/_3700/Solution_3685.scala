package leetCode._3700

object Solution_3685 {
  def subsequenceSumAfterCapping(nums: Array[Int], k: Int): Array[Boolean] = {
    val sorted = nums.sorted
    val n = sorted.length
    val u = (BigInt(1) << (k + 1)) - 1

    val freq: Map[Int, Int] = sorted.groupBy(identity).mapValues(_.length).toMap

    def canHit(bit: BigInt, s: Int): Boolean =
      ((bit >> s) & 1) == 1

    def addValue(dp: BigInt, value: Int, cnt: Int): BigInt =
      (0 until cnt).foldLeft(dp)((f, _) => f | ((f << value) & u))

    @scala.annotation.tailrec
    def loop(x: Int, f: BigInt, remain: Int, acc: List[Boolean]): List[Boolean] =
      if (x > n) acc.reverse
      else {
        val cnt = freq.getOrElse(x, 0)
        val nf = if (cnt == 0) f else addValue(f, x, cnt)

        if (canHit(nf, k))
          acc.reverse ++ List.fill(n - x + 1)(true)
        else {
          val ok = (0 to (remain - cnt).min(k / x)).exists(j => canHit(nf, k - j * x))

          loop(x + 1, nf, remain - cnt, ok :: acc)
        }
      }

    loop(1, BigInt(1), n, Nil).toArray
  }
}
