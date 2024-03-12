package leetCode._2900

object Solution_2871 {
  def maxSubarrays(nums: Array[Int]): Int = {
    var res = 0
    var a = -1

    nums.foreach(x => {
      a &= x
      if (a == 0) {
        res += 1
        a = -1
      }
    })

    res.max(1)
  }
}
