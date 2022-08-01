package leetCode

object Solution_2348 {
  def zeroFilledSubarray(nums: Array[Int]): Long = nums
    .map(n => if (n == 0) "A" else "B")
    .mkString
    .split("B")
    .map(n => (n.length.toLong + 1) * n.length / 2)
    .sum
}
