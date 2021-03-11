package leetCode

object Solution_27 {
  def removeElement(nums: Array[Int], v: Int): Int = nums./:(0)((idx, cur) => {
    if (cur == v) idx
    else {
      nums(idx) = cur
      idx + 1
    }
  })
}
