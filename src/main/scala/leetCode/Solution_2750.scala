package leetCode

object Solution_2750 {
  def numberOfGoodSubarraySplits(nums: Array[Int]): Int = {
    val arr = nums.dropWhile(_ == 0)
    if (arr.isEmpty) 0
    else arr./:((1L, 0)) { case ((cnt, zeros), num) =>
      if (num == 0) (cnt, zeros + 1)
      else ((cnt * (zeros + 1)) % 1000000007, 0)
    }._1.toInt
  }
}
