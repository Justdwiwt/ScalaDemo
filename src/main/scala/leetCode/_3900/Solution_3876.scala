package leetCode._3900

object Solution_3876 {
  def uniformArray(nums1: Array[Int]): Boolean = {
    val (mnEven, mnOdd) = nums1.foldLeft((Int.MaxValue, Int.MaxValue)) {
      case ((e, o), x) =>
        if ((x & 1) == 0) (e.min(x), o)
        else (e, o.min(x))
    }

    mnOdd == Int.MaxValue || mnEven > mnOdd
  }
}
