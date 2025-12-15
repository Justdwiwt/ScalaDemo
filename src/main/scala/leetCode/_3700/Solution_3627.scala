package leetCode._3700

object Solution_3627 {
  def maximumMedianSum(nums: Array[Int]): Long = nums
    .sorted
    .reverse
    .foldLeft((false, 0, 0L))((t3, n) => {
      if (!t3._1) (t3._2 < nums.length / 3, t3._2, t3._3)
      else (false, t3._2 + 1, t3._3 + n.toLong)
    })._3
}
