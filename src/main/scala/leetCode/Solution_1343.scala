package leetCode

object Solution_1343 {
  def numOfSubarrays(arr: Array[Int], k: Int, threshold: Int): Int = arr
    .scanLeft(0)(_ + _)
    .sliding(k + 1)
    .map(x => if (x(k) - x(0) >= k * threshold) 1 else 0)
    .sum
}
