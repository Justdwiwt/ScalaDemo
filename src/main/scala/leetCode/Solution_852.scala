package leetCode

object Solution_852 {
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    var pLeft = 0
    var pRight = A.length - 1
    while (pLeft < pRight) {
      val mid = pLeft + (pRight - pLeft) / 2
      if (A(mid) > A(mid - 1) && A(mid) > A(mid + 1)) return mid
      else if (A(mid) > A(mid + 1)) pRight = mid - 1
      else pLeft = mid + 1
    }
    pLeft
  }
}
