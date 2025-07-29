package leetCode._3700

object Solution_3605 {
  def minStable(nums: Array[Int], maxC: Int): Int = {
    val n = nums.length

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a
      else gcd(b, a % b)

    def getCount(len: Int): Int = {
      var req = 0
      var i = 0
      while (i + len - 1 < n) {
        var g = nums(i)
        var j = i + 1
        while (j < i + len && g > 1) {
          g = gcd(g, nums(j))
          j += 1
        }
        if (g > 1) {
          req += 1
          i += len
        } else i += 1
      }
      req
    }

    var l = 0
    var r = n + 1
    while (l + 1 < r) {
      val mid = (l + r) / 2
      if (getCount(mid) <= maxC) r = mid
      else l = mid
    }
    l
  }
}
