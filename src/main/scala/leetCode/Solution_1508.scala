package leetCode

object Solution_1508 {
  def rangeSum(nums: Array[Int], n: Int, left: Int, right: Int): Int = {
    val arr = Array.ofDim[Int](n * (n + 1) / 2)
    var idx = 0
    (0 until n).foreach(i => {
      var sum = 0
      (i until n).foreach(j => {
        sum += nums(j)
        arr(idx) = sum
        idx += 1
      })
    })
    arr.sortWith(_ < _).slice(left - 1, left - 1 + right - left + 1)./:(0)((b, a) => (b + a) % 1000000007)
  }
}
