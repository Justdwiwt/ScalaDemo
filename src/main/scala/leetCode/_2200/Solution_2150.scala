package leetCode._2200

object Solution_2150 {
  def findLonely(nums: Array[Int]): List[Int] = {
    val m = nums.groupBy(identity).mapValues(_.length)
    m.keys.filter(x => m(x) == 1 && !m.contains(x + 1) && !m.contains(x - 1)).toList
  }
}
