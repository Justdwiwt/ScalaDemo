package leetCode

object Solution_152 {
  def maxProduct(nums: Array[Int]): Int = {
    var res = nums(0)
    var cnt = 1
    nums.indices.foreach(i => {
      cnt = cnt * nums(i)
      res = res.max(cnt)
      if (nums(i) == 0) cnt = 1
    })
    cnt = 1
    (nums.length - 1 to 0 by -1).foreach(i => {
      cnt = cnt * nums(i)
      res = res.max(cnt)
      if (nums(i) == 0) cnt = 1
    })
    res
  }
}
