package leetCode._1700

object Solution_1696 {
  private case class MaxScore(i: Int, value: Int)

  def maxResult(nums: Array[Int], k: Int): Int = nums
    .indices
    .tail
    .foldLeft(Array(MaxScore(0, nums(0)))) { (dp, j) =>
      val dp1 = Iterator.iterate(dp)(_.tail).dropWhile(_.head.i + k < j).next()
      val score = dp1.head.value + nums(j)
      val dp2 = Iterator.iterate(dp1)(_.dropRight(1)).dropWhile(_.lastOption.exists(_.value < score)).next()
      dp2 :+ MaxScore(j, score)
    }
    .last
    .value
}
