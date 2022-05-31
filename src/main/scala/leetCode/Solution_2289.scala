package leetCode

import scala.collection.mutable

object Solution_2289 {
  def totalSteps(nums: Array[Int]): Int = {
    var res = 0
    val st = mutable.Stack[Int]()
    val dp = Array.fill(nums.length)(0)
    nums.indices.foreach(i => {
      var mx = 0
      while (st.nonEmpty && nums(st.head) <= nums(i))
        mx = mx.max(dp(st.pop()))
      if (st.nonEmpty)
        dp(i) = mx + 1
      res = res.max(dp(i))
      st.push(i)
    })
    res
  }
}
