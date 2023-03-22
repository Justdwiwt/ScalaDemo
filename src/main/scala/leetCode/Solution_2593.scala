package leetCode

object Solution_2593 {
  def findScore(nums: Array[Int]): Long =
    f(nums.zipWithIndex.sorted.toList, Set.empty, 0)

  @scala.annotation.tailrec
  private def f(nums: List[(Int, Int)], marked: Set[Int], score: Long): Long = nums match {
    case Nil => score
    case (num, index) :: tail =>
      if (marked.contains(index)) f(tail, marked, score)
      else f(tail, marked ++ List(index - 1, index + 1), score + num)
  }
}
