package leetCode

object Solution_674 {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], last: Int, len: Int, max: Int): Int = l match {
      case Nil => len.max(max)
      case head :: tail =>
        if (head > last) f(tail, head, len + 1, max)
        else f(tail, head, 1, len.max(max))
    }

    f(nums.toList, Int.MinValue, 0, 0)
  }
}
