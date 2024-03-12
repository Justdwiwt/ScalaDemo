package leetCode._1300

import scala.collection.mutable

object Solution_1218 {
  def longestSubsequence(arr: Array[Int], difference: Int): Int = {
    var res = 1
    var m = new mutable.HashMap[Int, Int]()
    arr.foreach(i => {
      val t = m.getOrElse(i - difference, 0) + 1
      m += i -> t
      res = res.max(t)
    })
    res
  }
}
