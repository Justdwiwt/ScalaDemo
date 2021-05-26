package leetCode

object Solution_1862 {
  def sumOfFlooredPairs(nums: Array[Int]): Int = {
    var res = 0L
    val n = 100000
    val M = 1000000007
    val s = Array.fill(n + 1)(0)
    nums.foreach(n => s(n) += 1)
    (1 to n).foreach(i => s(i) += s(i - 1))
    nums.foreach(l => (l to n by l).foreach(j => {
      val gain = (j / l).toLong
      val r = (n + 1).min(j + l)
      res = (res + (s(r - 1) - s(j - 1)) * gain) % M
    }))
    res.toInt
  }
}
