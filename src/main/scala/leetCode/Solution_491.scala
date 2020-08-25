package leetCode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_491 {
  def findSubsequences(nums: Array[Int]): List[List[Int]] = {
    var res = new ListBuffer[List[Int]]
    if (nums.isEmpty) return List.empty
    backTrack(nums, Array.fill(nums.length)(0), 0, -1, Int.MinValue)

    def backTrack(nums: Array[Int], tmp: Array[Int], curPos: Int, preIdx: Int, pre: Int): Unit = {
      if (curPos > 1) {
        var t = List.empty[Int]
        (0 until curPos).foreach(i => t :+= tmp(i))
        res :+= t
      }
      var s = new mutable.HashSet[Int]()
      (preIdx + 1 until nums.length).foreach(i => {
        if (!s.contains(nums(i)) && nums(i) >= pre) {
          s += nums(i)
          tmp(curPos) = nums(i)
          backTrack(nums, tmp, curPos + 1, i, nums(i))
        }
      })
    }

    res.toList
  }
}
