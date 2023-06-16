package leetCode

object Solution_2731 {
  def sumDistance(nums: Array[Int], s: String, d: Int): Int = {
    val M = (1e9 + 7).toInt
    val ch = s.toCharArray
    nums.indices.foreach(i => {
      val c = ch(i)
      if (c == 'L') nums(i) -= d
      else nums(i) += d
    })
    var res = 0L
    var sum = 0L
    var cnt = 0L
    val sorted = nums.sorted
    nums.indices.reverse.foreach(i => {
      val n = sum - cnt * sorted(i)
      res = (res + n) % M
      sum += sorted(i)
      cnt += 1
    })
    (res % M).toInt
  }
}
