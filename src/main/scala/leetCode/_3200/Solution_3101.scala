package leetCode._3200

object Solution_3101 {
  def countAlternatingSubarrays(nums: Array[Int]): Long =
    nums.indices.foldLeft((0L, 0L)) { case ((cnt, total), i) =>
      val newCnt = if (i > 0 && nums(i) == nums(i - 1)) 1 else cnt + 1
      (newCnt, total + newCnt)
    }._2
}
