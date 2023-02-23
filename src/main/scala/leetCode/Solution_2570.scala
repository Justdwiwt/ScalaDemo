package leetCode

object Solution_2570 {
  def mergeArrays(nums1: Array[Array[Int]], nums2: Array[Array[Int]]): Array[Array[Int]] = (nums1 ++ nums2)
    .groupBy(g => g.head)
    .map(m => (m._1, m._2.map(m1 => m1.last).sum))
    .map(m => Array(m._1, m._2))
    .toArray
    .sortBy(_.head)
}
