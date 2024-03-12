package leetCode._100

object Solution_4 {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double =
    f(nums1.toList, nums2.toList)

  @scala.annotation.tailrec
  def f(n1: List[Int], n2: List[Int]): Double = (n1, n2) match {
    case (Nil, h2 :: Nil) => h2
    case (h1 :: Nil, Nil) => h1
    case (h1 :: Nil, h2 :: Nil) => (h1 + h2) / 2.0
    case (fst :: snd :: Nil, Nil) => (fst + snd) / 2.0
    case (Nil, fst :: snd :: Nil) => (fst + snd) / 2.0
    case (Nil, l2) => f(Nil, l2.dropRight(1).drop(1))
    case (l1, Nil) => f(Nil, l1.dropRight(1).drop(1))
    case (l1, l2) =>
      if (l1.head < l2.head)
        if (l1.last > l2.last) f(l1.drop(1).dropRight(1), l2)
        else f(l1.drop(1), l2.dropRight(1))
      else if (l1.last > l2.last) f(l1.dropRight(1), l2.drop(1))
      else f(l1, l2.drop(1).dropRight(1))
  }
}
