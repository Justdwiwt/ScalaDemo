package leetCode._3800

object Solution_3702 {
  def longestSubsequence(nums: Array[Int]): Int = {
    val xorAll = nums.foldLeft(0)(_ ^ _)
    if (xorAll == 0) nums.count(_ != 0) match {
      case 0 => 0
      case _ => nums.length - 1
    } else nums.length
  }
}
