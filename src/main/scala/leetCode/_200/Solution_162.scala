package leetCode._200

object Solution_162 {
  def findPeakElement(nums: Array[Int]): Int = {
    nums.indices.dropRight(1).takeWhile(i => nums(i) < nums(i + 1)).lastOption.getOrElse(-1) + 1
  }
}
