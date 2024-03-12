package leetCode._2600

object Solution_2593 {
  def findScore(nums: Array[Int]): Long = {
    @scala.annotation.tailrec
    def f(lists: List[(Int, Int)], marked: Set[Int], res: Long): Long = lists match {
      case Nil => res
      case (_, index) :: tail if marked.contains(index) => f(tail, marked, res)
      case (num, index) :: tail => f(tail, marked ++ List(index - 1, index + 1), res + num)
    }

    f(nums.zipWithIndex.sorted.toList, Set.empty, 0L)
  }
}
