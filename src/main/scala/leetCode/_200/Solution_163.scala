package leetCode._200

object Solution_163 {
  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[List[Int]] = {
    val nums2 = (lower - 1) +: nums :+ (upper + 1)
    val res = nums2.indices.dropRight(1).flatMap(i => {
      if (nums2(i) >= nums2(i + 1) - 1) None
      else if (nums2(i) == nums2(i + 1) - 2) Some(List(nums2(i) + 1))
      else Some(List(nums2(i) + 1, nums2(i + 1) - 1))
    })

    res
      .collect {
        case List(x) => List(x, x)
        case List(x, y) => List(x, y)
      }
      .toList
  }
}
