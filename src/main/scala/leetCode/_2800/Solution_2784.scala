package leetCode._2800

object Solution_2784 {
  def isGood(nums: Array[Int]): Boolean =
    nums.sorted.toSeq == nums.indices.drop(1) :+ nums.length - 1
}
