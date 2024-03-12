package leetCode._2900

object Solution_2848 {
  def numberOfPoints(nums: List[List[Int]]): Int = nums
    .collect { case List(start, end) => (start to end).toSet }
    .reduce(_ ++ _)
    .size
}
