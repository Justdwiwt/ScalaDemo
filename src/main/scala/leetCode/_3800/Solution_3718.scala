package leetCode._3800

object Solution_3718 {
  def missingMultiple(nums: Array[Int], k: Int): Int = Stream
    .from(k, k)
    .filter(!nums.toSet.filter(_ % k == 0).contains(_))
    .head
}
