package leetCode._3900

object Solution_3843 {
  def firstUniqueFreq(nums: Array[Int]): Int = {
    val map1 = nums
      .groupBy(identity)
      .map { case (k, v) => k -> v.length }

    val map2 = map1
      .values
      .toList
      .groupBy(identity)
      .map { case (k, v) => k -> v.length }

    nums.find(v => map2(map1(v)) == 1).getOrElse(-1)
  }
}
