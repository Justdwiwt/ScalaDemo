package leetCode

object Solution_327 {
  def countRangeSum(nums: Array[Int], lower: Int, upper: Int): Int = {
    var res = 0
    nums.indices.foreach(i => {
      var sum: Long = 0
      (i until nums.length).foreach(j => {
        sum += nums(j).toLong
        if (sum >= lower && sum <= upper) res += 1
      })
    })
    res
  }
}
