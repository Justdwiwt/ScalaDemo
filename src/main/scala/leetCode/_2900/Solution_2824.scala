package leetCode._2900

object Solution_2824 {
  def countPairs(nums: List[Int], target: Int): Int = nums match {
    case num :: tail => tail.count(_ + num < target) + countPairs(tail, target)
    case Nil => 0
  }
}
