package leetCode._3600

object Solution_3509 {
  def maxProduct(nums: Array[Int], k: Int, limit: Int): Int = {
    val initialStates = Set((0, 1, 1, false))

    val finalStates = nums.foldLeft(initialStates)((dp, num) => {
      val extended = dp.map { case (t, p, flag, _) =>
        val newT = t + flag * num
        val newP = (p.toLong * num).min(limit + 1).toInt
        val newFlag = flag * -1
        (newT, newP, newFlag, true)
      }
      dp ++ extended
    })

    finalStates
      .collect { case (t, p, _, picked) if picked && t == k && p <= limit => p }
      .foldLeft(-1)(_.max(_))
  }
}
