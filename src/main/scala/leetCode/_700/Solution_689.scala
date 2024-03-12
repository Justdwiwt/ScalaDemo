package leetCode._700

object Solution_689 {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    val arr = nums.scanLeft(0)(_ + _)
    val n = nums.length - k
    val sub = (0 to n).map(x => arr(x + k) - arr(x))
    val left = (1 to n).scanLeft(0) { (i, j) => if (sub(i) >= sub(j)) i else j }
    val right = (0 until n).scanRight(n) { (i, j) => if (sub(i) >= sub(j)) i else j }
    val mid = (k to n - k).maxBy(x => sub(left(x - k)) + sub(x) + sub(right(x + k)))
    Array(left(mid - k), mid, right(mid + k))
  }
}
