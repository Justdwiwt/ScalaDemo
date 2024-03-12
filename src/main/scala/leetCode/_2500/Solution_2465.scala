package leetCode._2500

object Solution_2465 {
  def distinctAverages(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(nums: Array[Int], acc: Array[Double]): Array[Double] =
      if (nums.isEmpty) acc
      else {
        val min = nums.min
        val max = nums.max
        val withoutMin = nums.takeWhile(_ != min) ++ nums.dropWhile(_ != min).tail
        val withoutMax = withoutMin.takeWhile(_ != max) ++ withoutMin.dropWhile(_ != max).tail
        f(withoutMax, acc :+ ((min + max) / 2.0))
      }

    f(nums, Array.emptyDoubleArray).toSet.size
  }
}
