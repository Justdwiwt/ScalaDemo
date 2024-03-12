package leetCode._2200

object Solution_2149 {
  def rearrangeArray(nums: Array[Int]): Array[Int] = nums
    .filter(_ > 0)
    .zip(nums.filter(_ < 0))
    .flatMap({ case (a, b) => Array(a, b) })
}
