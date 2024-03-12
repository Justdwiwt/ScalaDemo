package leetCode._900

object Solution_868 {
  def binaryGap(n: Int): Int = {
    var cnt = 0
    var res = 0
    n.toBinaryString.foreach(ch =>
      if (ch == '1') {
        res = res.max(cnt)
        cnt = 1
      } else cnt += 1
    )
    res
  }
}
