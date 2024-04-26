package leetCode._2000

import scala.collection.mutable

object Solution_1983 {
  def widestPairOfIndices(nums1: Array[Int], nums2: Array[Int]): Int =
    nums1.indices.foldLeft((0, 0, mutable.Map[Int, Int]() += (0 -> -1))) {
      case ((res, p, m), i) =>
        val newP = p + nums1(i) - nums2(i)
        val newRes = if (m.contains(newP)) res.max(i - m(newP)) else res
        m(newP) = if (m.contains(newP)) m(newP) else i
        (newRes, newP, m)
    }._1
}
