package leetCode._3100

object Solution_3038 {
  def maxOperations(nums: Array[Int]): Int = (nums :+ Int.MaxValue)
    .grouped(2)
    .map(_.sum)
    .sliding(2)
    .takeWhile { case Seq(a, b) => a == b }
    .size + 1
}
