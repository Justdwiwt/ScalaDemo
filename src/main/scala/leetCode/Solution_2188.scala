package leetCode

object Solution_2188 {
  def minimumFinishTime(tires: Array[Array[Int]], changeTime: Int, numLaps: Int): Int = {
    val arr = Array.fill(20)(Int.MaxValue / 2.toLong)
    var cnt = 0
    tires.foreach(t => {
      var r = t.head
      var j = 1
      var sum = 0
      while (r < changeTime + t.head) {
        sum += r
        cnt = cnt.max(j)
        arr(j) = arr(j).min(sum + changeTime)
        r = r * t(1)
        j += 1
      }
    })
    val dp = Array.fill(numLaps + 1)(Int.MaxValue / 2.toLong)
    dp(0) = 0L
    (1 to numLaps).foreach(i => (1 to i.min(cnt)).foreach(j => dp(i) = dp(i).min(dp(i - j) + arr(j))))
    (dp(numLaps) - changeTime).toInt
  }
}
