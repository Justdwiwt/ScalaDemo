package leetCode._2500

object Solution_2453 {
  def destroyTargets(nums: Array[Int], space: Int): Int = nums
    .sorted
    .groupBy(_ % space)
    .values
    .maxBy(n => (n.length, -n.head))
    .head
}
