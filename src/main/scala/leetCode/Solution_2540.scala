package leetCode

object Solution_2540 {
  def getCommon(nums1: Array[Int], nums2: Array[Int]): Int =
    scala.util.Try(nums1.intersect(nums2).min).getOrElse(-1)
}
