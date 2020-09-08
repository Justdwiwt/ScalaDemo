package leetCode

object Solution_532 {
  def findPairs(nums: Array[Int], k: Int): Int =
    if (k < 0) 0
    else if (k == 0) nums.groupBy(identity).count(_._2.length > 1)
    else {
      val s = nums.toSet
      s.count(n => s.contains(n + k))
    }
}
