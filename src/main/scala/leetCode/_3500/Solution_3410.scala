package leetCode._3500

object Solution_3410 {
  def maxSubarraySum(nums: Array[Int]): Long = {
    val initialState = (Long.MinValue, 0L, 0L, 0L, Map.empty[Int, Long])
    nums.foldLeft(initialState) { case ((ans, s, nonDelMinS, allMin, delMinS), x) =>
      val newS = s + x
      val newAns = ans.max(newS - allMin)
      if (x < 0) {
        val updatedDelMinS = delMinS.updated(x, nonDelMinS.min(delMinS.getOrElse(x, Long.MaxValue)) + x)
        val newAllMin = allMin.min(updatedDelMinS(x))
        val newNonDelMinS = newS.min(nonDelMinS)
        (newAns, newS, newNonDelMinS, newAllMin, updatedDelMinS)
      } else (newAns, newS, nonDelMinS, allMin, delMinS)
    }._1
  }
}
