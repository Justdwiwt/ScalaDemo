package leetCode._2600

object Solution_2541 {
  def minOperations(nums1: Array[Int], nums2: Array[Int], k: Int): Long =
    if (k == 0) if (nums1.sameElements(nums2)) 0 else -1
    else {
      val diff = nums1.indices.map(i => nums1(i) - nums2(i))
      val res = diff.:\((0L, 0L)) { case (i, (pos, neg)) =>
        if (pos == -1 || neg == -1 || i % k != 0) (-1, -1)
        else if (i > 0) (pos + i / k, neg)
        else if (i < 0) (pos, neg - i / k)
        else (pos, neg)
      }
      res match {
        case (-1, _) => -1
        case (_, -1) => -1
        case (pos, neg) => if (pos == neg) pos else -1
      }
    }
}
