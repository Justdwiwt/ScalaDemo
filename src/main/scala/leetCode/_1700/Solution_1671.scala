package leetCode._1700

object Solution_1671 {
  def minimumMountainRemovals(nums: Array[Int]): Int = {
    val arrForward = Array.fill(nums.length)(1)
    val arrBackward = Array.fill(nums.length)(1)

    @scala.annotation.tailrec
    def findForward(startIdx: Int, curIdx: Int): Unit =
      if (curIdx == nums.length) ()
      else if (startIdx == curIdx) findForward(0, curIdx + 1)
      else if (nums(curIdx) > nums(startIdx)) {
        arrForward(curIdx) = arrForward(curIdx).max(arrForward(startIdx) + 1)
        findForward(startIdx + 1, curIdx)
      } else findForward(startIdx + 1, curIdx)

    @scala.annotation.tailrec
    def findBackward(startIdx: Int, curIdx: Int): Unit =
      if (curIdx < 0) ()
      else if (startIdx == curIdx) findBackward(nums.length - 1, curIdx - 1)
      else if (nums(curIdx) > nums(startIdx)) {
        arrBackward(curIdx) = arrBackward(curIdx).max(arrBackward(startIdx) + 1)
        findBackward(startIdx - 1, curIdx)
      } else findBackward(startIdx - 1, curIdx)

    @scala.annotation.tailrec
    def findMxLength(idx: Int = 1, curMx: Int = 0): Int =
      if (idx == nums.length - 1) curMx
      else if (arrBackward(idx) == 1 || arrForward(idx) == 1) findMxLength(idx + 1, curMx)
      else findMxLength(idx + 1, curMx.max(arrBackward(idx) + arrForward(idx) - 1))

    if (nums.length == 1) 1
    else {
      findForward(0, 1)
      findBackward(nums.length - 1, nums.length - 2)
      nums.length - findMxLength()
    }
  }
}
