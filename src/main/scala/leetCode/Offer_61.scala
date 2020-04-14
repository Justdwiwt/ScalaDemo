package leetCode

object Offer_61 {
  def isStraight(nums: Array[Int]): Boolean = {
    val t = nums.sorted
    (0 until 4).foreach(i => {
      if (t(i) != 0) {
        if (t(4) - t(i) >= 5) return false
        if (t(i) == t(i + 1)) return false
      }
    })
    true
  }
}
