package leetCode._2300

object Solution_2294 {
  def partitionArray(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    if (sorted.isEmpty) return 0

    def f(first: Int, list: List[Int]): Int = list match {
      case Nil => 1
      case head :: tail => if (head - first > k) 1 + f(head, tail) else f(first, tail)
    }

    f(sorted.head, sorted.tail.toList)
  }
}
