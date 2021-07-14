package leetCode

import scala.collection.mutable

object Solution_1818 {
  def minAbsoluteSumDiff(nums1: Array[Int], nums2: Array[Int]): Int = {
    val ts = new mutable.TreeSet[Int]()((x, y) => Integer.compare(x, y))
    nums1.foreach(ts.add)

    val total: Long = nums1.indices.map(i => math.abs(nums1(i) - nums2(i)).toLong).sum

    //    (nums1.indices.map(i => math.min(
    //      ts.maxBefore(nums2(i)) match {
    //        case Some(x) => math.abs(x - nums2(i)).toLong
    //        case _ => Long.MaxValue
    //      },
    //      ts.minAfter(nums2(i)) match {
    //        case Some(x) => math.abs(x - nums2(i)).toLong
    //        case _ => Long.MaxValue
    //      }
    //    ) + total - math.abs(nums1(i) - nums2(i))
    //    ).min % (math.pow(10, 9) + 7)).toInt
    0
  }
}
