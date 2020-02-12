package leetCode

object Offer_10_1 {
  def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ =>
      val dp = Array.fill(n + 1)(0L)
      dp(0) = 0L
      dp(1) = 1L
      (2 to n).foreach(i => dp(i) = (dp(i - 1) + dp(i - 2)) % 1000000007)
      dp(n).toInt
  }
}
