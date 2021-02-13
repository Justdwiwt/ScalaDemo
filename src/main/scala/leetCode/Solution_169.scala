package leetCode

object Solution_169 {
  def majorityElement(nums: Array[Int]): Int = nums
    .groupBy(x => x)
    .mapValues(_.length)
    .maxBy(_._2)
    ._1
}
