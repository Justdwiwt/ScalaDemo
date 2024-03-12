package leetCode._3000

object Solution_2997 {
  def minOperations(nums: Array[Int], k: Int): Int =
    Integer.bitCount((nums :+ k).reduce(_ ^ _))
}
