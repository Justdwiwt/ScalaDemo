package leetCode._2600

object Solution_2598 {
  def findSmallestInteger(nums: Array[Int], value: Int): Int = {
    val arr = Array.fill(value)(0)
    nums.foreach(n => arr((n % value + value) % value) = arr((n % value + value) % value) + 1)
    val res = arr.zipWithIndex.minBy(_._1)
    res._1 * value + res._2
  }
}
