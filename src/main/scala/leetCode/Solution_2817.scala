package leetCode

import scala.collection.mutable

object Solution_2817 {
  def minAbsoluteDifference(nums: List[Int], x: Int): Int = {
    val arr = nums.toArray
    val st = mutable.TreeSet[Int]()
    var res = (arr.last - arr.head).abs
    (x until arr.length).foreach(i => {
      st += arr(i - x)
      val left = (st to arr(i)).lastOption.getOrElse(-1000000001)
      res = res.min(arr(i) - left)
      val right = (arr(i) to st.last).headOption.getOrElse(2000000001)
      res = res.min(right - arr(i))
    })
    res
  }
}
