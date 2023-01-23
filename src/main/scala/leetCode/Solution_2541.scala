package leetCode

object Solution_2541 {
  def minOperations(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {
    lazy val (_neg, _pos) = nums1
      .zip(nums2)
      .toList
      .map { case (a, b) => a - b }
      .filter(_ != 0)
      .groupBy(identity)
      .mapValues(_.size)
      .partition(_._1 < 0)

    lazy val (neg, pos) = (_neg.map { case (a, b) => -a -> b }.toMap, _pos.toMap)

    lazy val cnt = List(neg, pos).map(_.map { case (x, v) => (x.toLong / k) * v }.sum)

    if (k == 0) if (nums1.zip(nums2).forall { case (a, b) => a == b }) 0 else -1
    else if ((neg.keys ++ pos.keys).exists(x => x % k != 0) || cnt.head != cnt(1)) -1
    else cnt.head
  }
}
