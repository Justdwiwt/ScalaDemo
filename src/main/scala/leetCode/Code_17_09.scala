package leetCode

object Code_17_09 {
  def getKthMagicNumber(k: Int): Int = {
    var i3, i5, i7 = 0
    val dp = Array.fill(k)(0)
    dp(0) = 1
    (1 until k).foreach(i => {
      dp(i) = (3 * dp(i3)).min(5 * dp(i5)).min(7 * dp(i7))
      if (dp(i) == 3 * dp(i3)) i3 += 1
      if (dp(i) == 5 * dp(i5)) i5 += 1
      if (dp(i) == 7 * dp(i7)) i7 += 1
    })
    dp(k - 1)
  }
}
