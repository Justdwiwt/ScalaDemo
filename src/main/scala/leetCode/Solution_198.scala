package leetCode

object Solution_198 {
  def rob(nums: Array[Int]): Int = {
    var p = 0
    var q = 0
    nums.indices.foreach(i => {
      if (i % 2 == 0) {
        q += nums(i)
        q = p.max(q)
      } else {
        p += nums(i)
        p = p.max(q)
      }
    })
    p.max(q)
  }
}
