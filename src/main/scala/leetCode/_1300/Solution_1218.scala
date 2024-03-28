package leetCode._1300

object Solution_1218 {
  def longestSubsequence(arr: Array[Int], difference: Int): Int = arr
    .foldLeft(Map.empty[Int, Int])((res, n) => res.updated(n, res.getOrElse(n - difference, 0) + 1))
    .values
    .max
}
