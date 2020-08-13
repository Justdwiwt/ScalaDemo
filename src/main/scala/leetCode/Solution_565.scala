package leetCode

object Solution_565 {
  def arrayNesting(nums: Array[Int]): Int = {
    var res = 1
    nums.indices.foreach(i => {
      if (res > nums.length / 2) return res
      var curMx = 1
      var cur = nums(nums(i))
      while (nums(i) != cur) {
        curMx += 1
        cur = nums(cur)
      }
      res = res.max(curMx)
    })
    res
  }
}
