package leetCode

object Solution_532 {
  def findPairs(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(remaining: List[Int], pairs: Set[(Int, Int)]): Set[(Int, Int)] = remaining match {
      case Nil => pairs
      case head :: tail if tail.contains(head + k) => f(tail, pairs + ((head, head + k)))
      case _ :: tail => f(tail, pairs)
    }

    f(nums.sorted.toList, Set.empty).size
  }
}
