package leetCode._4000

object Solution_3903 {
  def firstStableIndex(nums: Array[Int], k: Int): Int = {
    val maxNum = nums.scanLeft(Int.MinValue)(_.max(_)).tail
    val minNum = nums.scanRight(Int.MaxValue)(_.min(_)).init
    maxNum.zip(minNum).map(m => m._1 - m._2).zipWithIndex.find(_._1 <= k).map(_._2).getOrElse(-1)
  }
}
