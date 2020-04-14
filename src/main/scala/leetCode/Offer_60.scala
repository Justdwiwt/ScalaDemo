package leetCode

object Offer_60 {
  def twoSum(n: Int): Array[Double] = {
    val p = 1.0 / 6
    val dp = Array.fill(n + 1, n * 6 + 1)(0.0)
    dp(0)(0) = 1.0
    (1 to n).foreach(i => (i to 6 * i).foreach(j => dp(i)(j) = (1 to 6).filter(_ <= j).map(k => dp(i - 1)(j - k) * p).sum))
    dp(n).filter(_ > 0)
  }
}
