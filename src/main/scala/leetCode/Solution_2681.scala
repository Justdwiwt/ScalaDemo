package leetCode

object Solution_2681 {
  def sumOfPower(nums: Array[Int]): Int = {
    val M = (1e9 + 7).toInt
    val sorted = nums.sorted
    var pre = 0L
    var res = 0L
    sorted.indices.foreach(i => {
      res = (res + pre * sorted(i) % M * sorted(i) + sorted(i).toLong * sorted(i) % M * sorted(i)) % M
      pre = (pre * 2 + sorted(i)) % M
    })
    res.toInt
  }
}
