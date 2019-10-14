package leetCode

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting.quickSort

object Solution_4 {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var num: Array[Int] = null
    var mid: Double = 0.0
    if (nums1.isEmpty) num = nums2
    else if (nums2.isEmpty) num = nums1
    if (num != null) {
      val pA = num.length / 2
      val pB = (num.length - 1) / 2
      mid = (num(pA) + num(pB)) / 2.0
    } else {
      val pA = (nums1.length + nums2.length) / 2
      val pB = (nums1.length + nums2.length - 1) / 2
      val pc = new ArrayBuffer[Int]()
      nums1.copyToBuffer(pc)
      nums2.copyToBuffer(pc)
      val temp = pc.toArray
      quickSort(temp)
      mid = (temp(pA) + temp(pB)) / 2.0
    }
    mid
  }
}
