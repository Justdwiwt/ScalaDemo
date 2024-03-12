package leetCode._700

object Solution_628 {
  def maximumProduct(nums: Array[Int]): Int = {
    val withIdx = nums.sorted.zipWithIndex
    (withIdx.take(3) ++ withIdx.takeRight(3))
      .toSet.toList.combinations(3)
      .map(_.map(_._1).product)
      .max
  }
}
