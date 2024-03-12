package leetCode._2400

object Solution_2312 {
  def sellingWood(m: Int, n: Int, prices: Array[Array[Int]]): Long = {
    val dp = Array.ofDim[Long](m + 1, n + 1)
    prices.foreach(p => dp(p.head)(p(1)) = p(2))
    (1 to m).foreach(w => (1 to n).foreach(h => {
      (1 to w / 2).foreach(a => dp(w)(h) = dp(w)(h).max(dp(a)(h) + dp(w - a)(h)))
      (1 to h / 2).foreach(a => dp(w)(h) = dp(w)(h).max(dp(w)(a) + dp(w)(h - a)))
    }))
    dp(m)(n)
  }
}
