package leetCode._2700

object Solution_2610 {
  def findMatrix(nums: Array[Int]): List[List[Int]] = {
    val m = nums.groupBy(identity).mapValues(_.length)
    (0 until m.values.max).map(i => m.keys.filter(m.getOrElse(_, 0) > i)).map(_.toList).toList
  }
}
