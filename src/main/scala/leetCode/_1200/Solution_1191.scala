package leetCode._1200

object Solution_1191 {
  def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
    val M = 1e9.toInt + 7
    var res = 0
    var minPrefix = 0
    var sum = 0
    arr.foreach(i => {
      sum += i
      res = res.max(sum - minPrefix)
      minPrefix = minPrefix.min(sum)
    })
    if (k > 1) {
      val t = sum.toLong
      arr.foreach(i => {
        sum += i
        res = res.max(sum - minPrefix)
        minPrefix = minPrefix.min(sum)
      })
      res %= M
      if (t > 0) res = res.max(((t * (k - 2) + res) % M).toInt)
    }
    res
  }
}
