package leetCode._2600

object Solution_2576 {
  def maxNumOfMarkedIndices(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(leftSorted: Array[Int], rightSorted: Array[Int], res: Int): Int = (leftSorted, rightSorted) match {
      case (l, r) if l.isEmpty || r.isEmpty => res
      case (l, r) if l.head * 2 <= r.head => f(l.tail, r.tail, res + 2)
      case (l, r) => f(l, r.tail, res)
    }

    val (leftSorted, rightSorted) = nums.sorted.splitAt(nums.length / 2)
    f(leftSorted, rightSorted, 0)
  }
}
