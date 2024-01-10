package leetCode

object Solution_2997 {
  def minOperations(nums: Array[Int], k: Int): Int = {
    var t = k
    nums.foreach(i => t ^= i)
    Integer.bitCount(t)
  }
}
