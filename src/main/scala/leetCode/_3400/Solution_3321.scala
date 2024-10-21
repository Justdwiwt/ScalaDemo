package leetCode._3400

import scala.collection.mutable

// fixme: case 776/784 memory limit exceeded
object Solution_3321 {
  def findXSum(nums: Array[Int], k: Int, x: Int): Array[Long] = {
    val n = nums.length
    val res = new Array[Long](n - k + 1)

    val frequencyMap = mutable.Map.empty[Int, Int]

    (0 until k).foreach(i => frequencyMap(nums(i)) = frequencyMap.getOrElse(nums(i), 0) + 1)

    def calculateXSum(): Long = frequencyMap
      .toSeq
      .sortBy { case (num, freq) => (-freq, -num) }
      .take(x)
      .map { case (num, freq) => num.toLong * freq }
      .sum

    res(0) = calculateXSum()

    (1 until n - k + 1).foreach(i => {
      val outgoingElement = nums(i - 1)
      frequencyMap(outgoingElement) -= 1
      if (frequencyMap(outgoingElement) == 0) frequencyMap.remove(outgoingElement)

      val incomingElement = nums(i + k - 1)
      frequencyMap(incomingElement) = frequencyMap.getOrElse(incomingElement, 0) + 1

      res(i) = calculateXSum()
    })

    res
  }
}
