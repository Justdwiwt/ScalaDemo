package leetCode

object Solution_2341 {
  def numberOfPairs(nums: Array[Int]): Array[Int] = {
    val arr = Array.fill(101)(0)
    nums.foreach(arr(_) += 1)
    Array(arr.map(_ / 2).sum, arr.map(_ % 2).sum)
  }
}
