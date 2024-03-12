package leetCode.LCP

object LCP_29 {
  def orchestraLayout(num: Int, xPos: Int, yPos: Int): Int = {
    val M = xPos.min(yPos).min(num - xPos - 1).min(num - yPos - 1).toLong
    var start = 1
    var cnt = ((num * M) - M * M) * 4
    start = ((cnt + start - 1) % 9 + 1).toInt
    val n = num - M * 2
    cnt = (n - 1) * 4
    var dist = xPos.toLong + yPos.toLong - 2 * M
    if (xPos == n + M - 1 || (yPos == M && xPos != M)) dist = cnt - dist
    ((dist + start - 1) % 9 + 1).toInt
  }
}
