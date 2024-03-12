package leetCode._1000

object Solution_935 {
  def knightDialer(N: Int): Int = {
    val M = 1e9.toInt + 7
    val dp = Array.ofDim[Int](10, N) // dp(x)(y): x: start num, y: steps
    (0 to 9).foreach(i => dp(i)(0) = 1)
    (1 until N).foreach(step => {
      dp(0)(step) = dp(4)(step - 1) + dp(6)(step - 1)
      dp(1)(step) = dp(6)(step - 1) + dp(8)(step - 1)
      dp(2)(step) = dp(7)(step - 1) + dp(9)(step - 1)
      dp(3)(step) = dp(8)(step - 1) + dp(4)(step - 1)
      dp(4)(step) = (dp(3)(step - 1) + dp(9)(step - 1)) % M + dp(0)(step - 1)
      dp(5)(step) = 0
      dp(6)(step) = (dp(7)(step - 1) + dp(1)(step - 1)) % M + dp(0)(step - 1)
      dp(7)(step) = dp(2)(step - 1) + dp(6)(step - 1)
      dp(8)(step) = dp(1)(step - 1) + dp(3)(step - 1)
      dp(9)(step) = dp(2)(step - 1) + dp(4)(step - 1)
      (0 to 9).foreach(i => dp(i)(step) = dp(i)(step) % M)
    })
    var res = 0
    (0 to 9).foreach(i => res = (res + dp(i)(N - 1)) % M)
    res
  }
}
