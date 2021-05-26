package leetCode

object Solution_1848 {
  def getMinDistance(nums: Array[Int], target: Int, start: Int): Int = nums
    .zipWithIndex
    .map(x => if (x._1 == target) (x._2 - start).abs else nums.length)
    .min
}
