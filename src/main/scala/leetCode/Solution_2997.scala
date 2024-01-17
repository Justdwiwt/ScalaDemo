package leetCode

object Solution_2997 {
  def minOperations(nums: Array[Int], k: Int): Int =
    Integer.bitCount((nums :+ k).reduce(_ ^ _))
}
