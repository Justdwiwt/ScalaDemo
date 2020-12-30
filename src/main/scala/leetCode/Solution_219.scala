package leetCode

object Solution_219 {
  def containsNearbyDuplicate(nums: Array[Int], maxDiff: Int): Boolean = {
    def f(indices: Array[Int]): Boolean =
      indices
        .sliding(2)
        .map({
          case Array(x, y) => y - x <= maxDiff
          case _ => false
        }).exists(identity)

    nums
      .zipWithIndex
      .groupBy(_._1)
      .values
      .map(v => f(v.map(_._2)))
      .exists(identity)
  }
}
