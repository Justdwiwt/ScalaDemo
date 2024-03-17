package leetCode._2400

object Solution_2364 {
  def countBadPairs(nums: Array[Int]): Long = nums
    .indices
    .foldLeft(Map[Int, Int](), 0L)((acc, i) => {
      val diff = i - nums(i)
      val t2 = if (acc._1.contains(diff)) acc._2 + i - acc._1.getOrElse(diff, 0) else acc._2 + i
      (acc._1 + (diff -> (acc._1.getOrElse(diff, 0) + 1)), t2)
    })
    ._2
}
