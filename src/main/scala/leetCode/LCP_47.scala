package leetCode

object LCP_47 {
  def securityCheck(capacities: Array[Int], k: Int): Int = {
    val M = 1000000007
    capacities.indices.foreach(i => capacities(i) -= 1)
    val dp = Array.fill(k + 1)(0)
    dp(0) = 1
    capacities.indices.foreach(i => (k to capacities(i) by -1).foreach(j =>
      dp(j) = (dp(j) + dp(j - capacities(i))) % M
    ))
    dp(k)
  }
}
