package leetCode._1900

object Solution_1862 {
  def sumOfFlooredPairs(nums: Array[Int]): Int = {
    val M = (1e9 + 7).toInt
    val arr = Array.fill(nums.max + 1)(0)
    nums.foreach(num => arr(num) += 1)
    arr.indices.drop(1).foreach(i => arr(i) += arr(i - 1))
    var cnt = 0L
    arr.indices.drop(1).foreach(i => {
      val nCnt = arr(i) - arr(i - 1)
      if (nCnt > 0) {
        var m = 1L
        ((i << 1) - 1 until arr.length + i - 1 by i).foreach(j => {
          cnt += nCnt * m % M * (arr(j.min(arr.length - 1)) - arr(j - i))
          cnt %= M
          m += 1
        })
      }
    })
    cnt.toInt
  }
}
