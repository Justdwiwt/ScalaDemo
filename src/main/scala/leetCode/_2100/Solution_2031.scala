package leetCode._2100

import scala.collection.mutable

object Solution_2031 {
  val M: Int = 1000000007

  def subarraysWithMoreZerosThanOnes(nums: Array[Int]): Int = {
    var res = 0
    val m = mutable.Map.empty[Int, Int] += (0 -> 1)
    var currSum = 0
    var ltCurrSum = 0

    nums.indices.foreach(i => {
      if (nums(i) == 0) {
        currSum -= 1
        ltCurrSum -= m.getOrElse(currSum, 0)
      } else {
        ltCurrSum += m.getOrElse(currSum, 0)
        currSum += 1
      }
      m(currSum) = m.getOrElse(currSum, 0) + 1
      res = (res + ltCurrSum) % M
    })
    res
  }
}
