package leetCode

object Solution_821 {
  def shortestToChar(S: String, C: Char): Array[Int] = {
    val N = S.length
    val ans = Array.fill(N)(Int.MaxValue)
    val posE = S.zipWithIndex.filter(_._1 == C).map(_._2)
    var step = 0
    while (ans.max == Int.MaxValue) {
      posE.foreach(idx => {
        if (idx + step < N) ans(idx + step) = ans(idx + step) min step
        if (idx - step >= 0) ans(idx - step) = ans(idx - step) min step
      })
      step += 1
    }
    ans
  }
}
