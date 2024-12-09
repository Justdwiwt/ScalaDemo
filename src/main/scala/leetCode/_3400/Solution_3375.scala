package leetCode._3400

object Solution_3375 {
  def minOperations(nums: Array[Int], k: Int): Int = {
    val mn = nums.min
    if (k > mn) -1
    else nums.distinct.length - (if (k == mn) 1 else 0)
  }
}
