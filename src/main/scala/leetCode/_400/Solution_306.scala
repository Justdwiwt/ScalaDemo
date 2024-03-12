package leetCode._400

object Solution_306 {

  def isAdditiveNumber(num: String): Boolean = {
    backTrack(num, 0, 0, 0, 0)
  }

  def backTrack(num: String, index: Int, preSum: Long, preNum: Long, k: Int): Boolean = {
    if (k > 2 && index >= num.length) return true
    var len = 1
    while (len + index <= num.length) {
      val f = isSum(preSum, num, index, index + len - 1, k)
      if (f >= 0 && backTrack(num, index + len, f + preNum, f, k + 1)) return true
      len += 1
    }
    false
  }

  def isSum(sum: Long, num: String, l: Int, h: Int, k: Int): Long = {
    if (num(l) == '0' && l < h) return -1
    var s: Long = 0
    var t = l
    while (t <= h) {
      s = s * 10 + num(t) - '0'
      t += 1
    }
    if (k < 2) return s
    if (sum == s) s else -1
  }

}
