package leetCode._200

object Solution_164 {
  def maximumGap(nums: Array[Int]): Int = {
    if (nums.length < 2) return 0
    val t = nums.sorted
    var res = t(1) - t(0)
    (2 until t.length).foreach(i => {
      val v = t(i) - t(i - 1)
      res = res.max(v)
    })
    res
  }
}
