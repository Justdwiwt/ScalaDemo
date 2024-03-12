package leetCode._1700

object Solution_1687 {
  def boxDelivering(boxes: Array[Array[Int]], portsCount: Int, maxBoxes: Int, maxWeight: Int): Int = {
    val dp = Array.fill(boxes.length + 1)(0)
    var weight = 0
    var cnt = 2
    var l = 0
    var r = 0
    while (r < boxes.length) {
      weight += boxes(r)(1)
      if (r != 0 && boxes(r).head != boxes(r - 1).head) cnt += 1
      while (r - l >= maxBoxes || weight > maxWeight || (l < r && dp(l) == dp(l + 1))) {
        weight -= boxes(l)(1)
        if (boxes(l + 1).head != boxes(l).head) cnt -= 1
        l += 1
      }
      dp(r + 1) = cnt + dp(l)
      r += 1
    }
    dp(boxes.length)
  }
}
