package leetCode._3500

object Solution_3434 {
  def maxFrequency(nums: Array[Int], k: Int): Int = nums
    .foldLeft((0, 0, Array.fill(51)(0))) { case ((f0, maxF12, f1), x) =>
      if (x == k) (f0 + 1, maxF12 + 1, f1) else {
        val updatedF1 = f1.updated(x, f1(x).max(f0) + 1)
        (f0, maxF12.max(updatedF1(x)), updatedF1)
      }
    }
    ._2
}
