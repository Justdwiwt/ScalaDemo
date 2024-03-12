package leetCode._1200

object Solution_1191 {
  def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
    val M = 1000000007.toLong
    var first = 0L
    var second = 0L
    var mxSum = 0L
    var sum = 0L
    (0 until 3).foreach(i => {
      arr.foreach(num => {
        sum = 0L.max(sum + num % M)
        mxSum = mxSum.max(sum)
      })
      if (i == 0) first = mxSum
      else if (i == 1) second = mxSum
    })
    val diff = mxSum - second
    (second + ((diff * (k - 2)) % M)).toInt
  }
}
