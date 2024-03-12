package leetCode._2900

object Solution_2815 {
  def maxSum(nums: Array[Int]): Int = nums
    .groupBy(_.toString.max)
    ./:(-1) { case (mx, (_, v)) =>
      if (v.length < 2) mx
      else mx.max(v.sorted.takeRight(2).sum)
    }
}
