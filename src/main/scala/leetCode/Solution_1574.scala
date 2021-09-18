package leetCode

object Solution_1574 {
  def findLengthOfShortestSubarray(arr: Array[Int]): Int = {
    @scala.annotation.tailrec
    def longestNonDecreasingPrefix(i: Int): Int =
      if (i >= arr.length - 1) arr.length - 1
      else if (arr(i) <= arr(i + 1)) longestNonDecreasingPrefix(i + 1)
      else i

    @scala.annotation.tailrec
    def longestNonIncreasingSuffix(i: Int): Int =
      if (i == 0) i
      else if (arr(i - 1) <= arr(i)) longestNonIncreasingSuffix(i - 1)
      else i

    @scala.annotation.tailrec
    def removeMiddleLoop(s: Int, e: Int, sLimit: Int, result: Int): Int =
      if (s > sLimit || e >= arr.length) result
      else if (arr(s) <= arr(e)) removeMiddleLoop(s + 1, e, sLimit, result.min(e - s - 1))
      else if (e < arr.length - 1) removeMiddleLoop(s, e + 1, sLimit, result)
      else result

    val prefixEnd = longestNonDecreasingPrefix(0)

    if (prefixEnd == arr.length - 1) 0
    else {
      val suffixStart = longestNonIncreasingSuffix(arr.length - 1)
      val stripPrefixOrSuffix = (arr.length - prefixEnd - 1).min(suffixStart)
      val removeMiddle = removeMiddleLoop(0, suffixStart, prefixEnd, Int.MaxValue)
      stripPrefixOrSuffix.min(removeMiddle)
    }
  }
}
