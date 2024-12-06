package leetCode._3400

object Solution_3371 {
  def getLargestOutlier(nums: Array[Int]): Int = {
    val cnt = nums.groupBy(identity).mapValues(_.length)
    val total = nums.sum
    nums.foldLeft(Int.MinValue)((res, y) => {
      val t = total - y * 2
      if (cnt.contains(t) && (t != y || cnt(t) > 1)) res.max(t)
      else res
    })
  }
}
