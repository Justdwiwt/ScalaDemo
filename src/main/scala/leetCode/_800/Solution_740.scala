package leetCode._800

object Solution_740 {
  def deleteAndEarn(nums: Array[Int]): Int = {
    val cnt = nums.groupBy(identity).mapValues(_.length)
    (1 to nums.max).foldLeft((0, 0)) {
      case ((prev, curr), n) => (curr, curr.max(prev + n * cnt.getOrElse(n, 0)))
    }._2
  }
}
