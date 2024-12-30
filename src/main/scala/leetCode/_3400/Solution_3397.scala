package leetCode._3400

object Solution_3397 {
  def maxDistinctElements(nums: Array[Int], k: Int): Int = {
    if (k * 2 + 1 >= nums.length) return nums.length
    val sorted = nums.sorted
    val INF = Int.MaxValue
    sorted.foldLeft((0, -INF)) { case ((ans, pre), x) =>
      val newX = (x - k).max(pre + 1).min(x + k)
      if (newX > pre) (ans + 1, newX)
      else (ans, pre)
    }._1
  }
}
