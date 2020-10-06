package leetCode

object Solution_1416 {
  def getDPs(s: String, k: Int): Array[Long] = {
    val arr = s.toCharArray.map(_.asDigit)
    val dps = new Array[Long](arr.length + 1)
    dps(dps.length - 1) = 1
    ((arr.length - 1) to(0, -1)).foreach { i =>
      if (arr(i) != 0) {
        var acc = 0L
        var curr = 0L
        var j = 0
        var flag = false
        while (i + j < arr.length && !flag) {
          curr = curr * 10 + arr(i + j)
          if (curr <= k) acc = (acc + dps(i + j + 1)) % 1000000007
          else flag = true
          j += 1
        }
        dps(i) = acc
      } else dps(i) = 0
    }
    dps
  }

  def numberOfArrays(s: String, k: Int): Int = {
    val dp = getDPs(s, k)
    dp(0).toInt
  }
}
