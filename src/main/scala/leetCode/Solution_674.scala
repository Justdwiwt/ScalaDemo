package leetCode

object Solution_674 {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    var res = 0
    var cnt = 0
    nums.indices.foreach(i => {
      if (i == 0 || nums(i - 1) < nums(i)) {
        cnt += 1
        res = math.max(res, cnt)
      } else cnt = 1
    })
    res
  }
}
