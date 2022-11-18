package leetCode

object Solution_891 {
  def sumSubseqWidths(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var n = 1L
    var sum = 0L
    var s = sorted.head.toLong
    var M = 1000000007
    nums.indices.drop(1).foreach(i => {
      sum = sum + sorted(i) * n % M - s
      if (sum >= M) sum -= M
      else if (sum < 0) sum += M
      s <<= 1
      s += sorted(i)
      s %= M
      n <<= 1
      n |= 1
      n %= M
    })
    sum.toInt
  }
}
