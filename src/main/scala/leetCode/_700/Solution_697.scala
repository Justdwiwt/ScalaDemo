package leetCode._700

object Solution_697 {
  def findShortestSubArray(nums: Array[Int]): Int = nums
    .zipWithIndex
    .groupBy(_._1)
    .values
    .map(v => v.length -> (v.maxBy(_._2)._2 - v.minBy(_._2)._2 + 1))
    .groupBy(_._1)
    .maxBy(_._1)
    ._2
    .minBy(_._2)
    ._2
}
