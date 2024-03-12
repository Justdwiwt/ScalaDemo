package leetCode._2800

object Solution_2784 {
  def isGood(nums: Array[Int]): Boolean =
    nums.sorted.toSeq == (1 until nums.length) :+ nums.length - 1
}
