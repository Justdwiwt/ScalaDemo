package leetCode._100

object Solution_75 {
  def sortColors(nums: Array[Int]): Unit = {
    def swap(s: Int, d: Int): Unit = {
      val t = nums(d)
      nums(d) = nums(s)
      nums(s) = t
    }

    nums.indices./:(0, 0, nums.length - 1) { case ((lo, mid, hi), _) if mid <= hi => nums(mid) match {
      case 0 =>
        swap(lo, mid)
        (lo + 1, mid + 1, hi)
      case 1 =>
        (lo, mid + 1, hi)
      case 2 =>
        swap(mid, hi)
        (lo, mid, hi - 1)
    }

    }
  }
}
