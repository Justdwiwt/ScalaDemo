package leetCode._2300

object Solution_2219 {
  def maximumSumScore(nums: Array[Int]): Long = {
    val pre = Array.fill(nums.length + 1)(0L)
    (1 to nums.length).foreach(i => pre(i) = pre(i - 1) + nums(i - 1))
    var res = Long.MinValue
    nums.indices.foreach(i => res = res.max(pre(i + 1).max(pre(nums.length) - pre(i))))
    res
  }
}
