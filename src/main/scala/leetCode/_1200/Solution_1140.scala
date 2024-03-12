package leetCode._1200

object Solution_1140 {
  def stoneGameII(piles: Array[Int]): Int = {
    val p = piles
    val dp = Array.fill(piles.length + 1, piles.length + 1)(0)
    (piles.length - 2 to 0 by -1).foreach(i => p(i) += p(i + 1))
    piles.indices.foreach(i => dp(i)(piles.length) = p(i))
    piles.indices.reverse.foreach(i => piles.indices.drop(1).reverse.foreach(m => (1 to 2 * m).foreach(x => if (i + x <= piles.length) dp(i)(m) = dp(i)(m).max(p(i) - dp(i + x)(m.max(x))))))
    dp.head(1)
  }
}
