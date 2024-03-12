package leetCode.offer

import scala.collection.mutable

object Offer_061 {
  def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
    val res = mutable.ListBuffer.empty[List[Int]]
    val st = mutable.Set.empty[(Int, Int)]
    val pq = mutable.PriorityQueue.empty[(Int, Int)](Ordering.by { case (a, b) => nums1(a) + nums2(b) }).reverse
    pq += ((0, 0))
    st += ((0, 0))
    while (res.size < k && pq.nonEmpty) {
      val (idx1, idx2) = pq.dequeue()
      if (idx1 < nums1.length - 1 && !st.contains((idx1 + 1, idx2))) {
        st += ((idx1 + 1, idx2))
        pq += ((idx1 + 1, idx2))
      }
      if (idx2 < nums2.length - 1 && !st.contains((idx1, idx2 + 1))) {
        st += ((idx1, idx2 + 1))
        pq += ((idx1, idx2 + 1))
      }
      res += List(nums1(idx1), nums2(idx2))
    }
    res.toList
  }
}
