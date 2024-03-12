package leetCode._2900

object Solution_2862 {
  def maximumSum(nums: List[Int]): Long = {
    var res = 0L
    val n = nums.length
    (1 to n by 1).foreach(i => {
      var sum = 0L
      var j = 1
      while (i * j * j <= n) {
        sum += nums(i * j * j - 1)
        j = j + 1
      }
      res = res.max(sum)
    })
    res
  }
}
