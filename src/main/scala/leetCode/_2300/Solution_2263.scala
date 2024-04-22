package leetCode._2300

object Solution_2263 {
  def convertArray(nums: Array[Int]): Int = {
    def f(nums: Array[Int]): Int = {
      val sorted = nums.toSet.toList.sorted
      val m = sorted.length

      val dp = Array.ofDim[Int](m)
      sorted.indices.foreach(j => dp(j) = (nums.head - sorted(j)).abs)
      nums.indices.drop(1).foreach(i => {
        var preMin = Int.MaxValue
        sorted.indices.foreach(j => {
          preMin = preMin.min(dp(j))
          dp(j) = preMin + (nums(i) - sorted(j)).abs
        })
      })

      dp.min
    }

    f(nums).min(f(nums.reverse))
  }
}
