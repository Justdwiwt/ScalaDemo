package leetCode

object Solution_1608 {
  def specialArray(nums: Array[Int]): Int = {
    (0 to nums.length).map(x => nums.count(_ >= x)).zipWithIndex.filter({ case (a, b) => a == b }).map(_._1).headOption.getOrElse(-1)
  }
}
