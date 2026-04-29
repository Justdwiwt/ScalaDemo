package leetCode._3900

object Solution_3866 {
  def firstUniqueEven(nums: Array[Int]): Int = {
    val set = nums.groupBy(identity).mapValues(_.length).filter(_._2 == 1).keySet
    nums.filter(_ % 2 == 0).dropWhile(!set.contains(_)).headOption.getOrElse(-1)
  }
}
