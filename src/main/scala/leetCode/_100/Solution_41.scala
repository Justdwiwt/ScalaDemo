package leetCode._100

object Solution_41 {
  def firstMissingPositive(nums: Array[Int]): Int = {
    val sorted = 0 +: nums.filter(x => x > 0).sorted
    sorted.sliding(2).collectFirst({ case Array(a, b) if b > a + 1 => a + 1 }).getOrElse(sorted.lastOption.map(_ + 1).getOrElse(1))
  }
}
