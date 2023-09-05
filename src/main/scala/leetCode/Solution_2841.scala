package leetCode

import scala.collection.mutable

object Solution_2841 {
  def maxSum(nums: List[Int], m: Int, k: Int): Long = {
    val frequencyMap = mutable.HashMap.empty[Int, Int]

    var startWindow = 0
    var currentSum = 0L
    var maxSum = 0L

    nums.indices.foreach(endWindow => {
      var currentNumber = nums(endWindow)
      frequencyMap += currentNumber -> (frequencyMap.getOrElse(currentNumber, 0) + 1)
      currentSum += currentNumber
      if (endWindow - startWindow + 1 > k) {
        var numberToRemove = nums(startWindow)
        currentSum -= numberToRemove
        if (frequencyMap(numberToRemove) == 1) frequencyMap.remove(numberToRemove)
        else frequencyMap += numberToRemove -> (frequencyMap(numberToRemove) - 1)
        startWindow += 1
      }
      if (endWindow - startWindow + 1 == k && frequencyMap.size >= m) maxSum = maxSum.max(currentSum)
    })
    maxSum
  }
}
