package leetCode._700

object Solution_634 {
  def findDerangement(n: Int): Int = n match {
    case 0 => 1
    case 1 => 0
    case _ =>
      val dp = Array.fill(n + 1)(0L)
      dp(0) = 1L
      dp(1) = 0L
      (2 to n).foreach(i => dp(i) = (i - 1) * (dp(i - 1) + dp(i - 2)) % (1e9 + 7).toLong)
      dp.last.toInt
  }
}
