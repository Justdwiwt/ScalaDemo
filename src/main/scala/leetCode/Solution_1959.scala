package leetCode

object Solution_1959 {
  def minSpaceWastedKResizing(nums: Array[Int], k: Int): Int = {
    val M = (1e9 + 7).toLong
    val sorted = nums.distinct.sorted
    var dp = Array.fill(k + 1)(Array.fill(sorted.length + 1)(M))
    sorted.indices.foreach(i => if (sorted(i) >= nums.head) {
      dp.head(i) = sorted(i) - nums.head
      dp.head(sorted.length) = dp.head(sorted.length).min(dp.head(i))
    })
    nums.indices.drop(1).foreach(t => {
      val next = Array.fill(k + 1)(Array.fill(sorted.length + 1)(M))
      sorted.indices
        .withFilter(i => sorted(i) >= nums(t))
        .foreach(size => {
          next.head(size) = dp.head(size) + sorted(size) - nums(t)
          (1 to t.min(k)).foreach(res => next(res)(size) = dp(res)(size).min(dp(res - 1)(sorted.length)) + sorted(size) - nums(t))
        })
      (0 to k).foreach(res => next(res)(sorted.length) = next(res).min)
      dp = next
    })
    dp.map(_.min).min.toInt
  }
}
