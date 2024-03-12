package leetCode._2600

object Solution_2554 {
  def maxCount(banned: Array[Int], n: Int, maxSum: Int): Int = {
    val banSet = banned.toSet
    val prefixSum = (1 to n).filterNot(banSet.contains).scanLeft(0)(_ + _).tail
    prefixSum.takeWhile(_ <= maxSum).length
  }
}
