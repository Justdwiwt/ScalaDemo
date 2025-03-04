package leetCode._3500

object Solution_3467 {
  def transformArray(nums: Array[Int]): Array[Int] = nums
    .map(n => if (n % 2 == 0) 0 else 1)
    .sorted
}
