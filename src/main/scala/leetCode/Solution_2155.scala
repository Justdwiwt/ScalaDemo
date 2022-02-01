package leetCode

import scala.collection.mutable.ListBuffer

object Solution_2155 {
  def maxScoreIndices(nums: Array[Int]): List[Int] = {
    val zero = nums.count(_ == 0)
    val res = new ListBuffer[Int]()
    var mx = -1
    var cur = 0
    (-1 until nums.length).foreach(i => {
      var sum = 0
      if (i == -1) sum = nums.length - zero
      else {
        if (nums(i) == 0) cur += 1
        sum = cur + (nums.length - i - 1 - (zero - cur))
      }
      if (sum > mx) {
        res.clear
        res += i + 1
        mx = sum
      } else if (sum == mx) res += i + 1
    })
    res.toList
  }
}
