package leetCode

object Solution_3038 {
  def maxOperations(nums: Array[Int]): Int = {
    val sum = nums.take(2).sum
    nums.grouped(2).takeWhile(arr => arr.length == 2 && arr.sum == sum).size
  }
}
