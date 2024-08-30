package leetCode._3300

object Solution_3269 {
  def minLargest(nums1: Array[Int], nums2: Array[Int]): Int = {
    def nextNumber(value: Int, odd: Int): Int = {
      var newValue = value + 1
      if ((newValue % 2) != odd) newValue += 1
      newValue
    }

    val dp = Array.fill(nums1.length + 1)(0)
    val dp2 = Array.fill(nums1.length + 1)(0)

    nums1.zipWithIndex.foreach { case (v, i) => dp(i + 1) = nextNumber(dp(i), v) }

    nums2.zipWithIndex.foreach { case (v2, _) => dp2(0) = nextNumber(dp.head, v2)
      nums1.zipWithIndex.foreach { case (v, i) => dp2(i + 1) = nextNumber(dp2(i), v).min(nextNumber(dp(i + 1), v2)) }
      dp.indices.foreach(i => dp(i) = dp2(i))
    }

    dp.last
  }
}
