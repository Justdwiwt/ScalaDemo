package leetCode._2900

import scala.collection.Searching._
import scala.collection.mutable.ArrayBuffer

object Solution_2863 {
  def maxSubarrayLength(nums: Array[Int]): Int = {
    var res = 0
    val buffer = ArrayBuffer((nums(0), 0))
    nums.indices.drop(1).foreach(i =>
      if (nums(i) > buffer.last._1) buffer += ((nums(i), i))
      else if (nums(i) == buffer.last._1) ()
      else {
        val ii = buffer.search((nums(i), Int.MaxValue)).insertionPoint
        res = res.max(i - buffer(ii)._2 + 1)
      })
    res
  }
}
