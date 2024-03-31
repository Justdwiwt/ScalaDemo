package leetCode._1000

object Solution_915 {
  def partitionDisjoint(nums: Array[Int]): Int = nums
    .scanLeft(Int.MinValue)(_.max(_))
    .zip(nums.scanRight(Int.MaxValue)(_.min(_)))
    .zipWithIndex
    .tail
    .filter(x => x._1._1 <= x._1._2)
    .head
    ._2
}
