package leetCode._500

object Solution_462 {
  def minMoves2(nums: Array[Int]): Int = {
    val t = nums.sorted
    t.map(i => math.abs(i - t(t.length / 2))).sum
  }
}
