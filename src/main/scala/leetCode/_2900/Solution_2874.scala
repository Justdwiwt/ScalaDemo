package leetCode._2900

object Solution_2874 {
  def maximumTripletValue(nums: Array[Int]): Long =
    nums.foldLeft((0L, 0, 0)) { case ((res, maxDiff, preMax), x) =>
      (res.max(maxDiff.toLong * x), maxDiff.max(preMax - x), preMax.max(x))
    }._1
}
