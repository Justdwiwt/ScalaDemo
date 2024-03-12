package leetCode._1900

object Solution_1829 {
  def getMaximumXor(nums: Array[Int], maximumBit: Int): Array[Int] = {
    val t = (1 << maximumBit) - 1
    val arr = nums.scanLeft(0)(_ ^ _).tail.reverse
    arr.map(_ ^ t)
  }
}
