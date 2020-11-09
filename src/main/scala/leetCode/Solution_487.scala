package leetCode

object Solution_487 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var p = 0
    var q = 0
    var res = 0
    nums.indices.foreach(i => {
      if (nums(i) == 0) {
        q = p + 1
        p = 0
      } else {
        p += 1
        q += 1
      }
      res = res.max(p.max(q))
    })
    res
  }
}
