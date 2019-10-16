package leetCode

object Solution_27 {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var ans = 0
    for (i <- nums)
      if (i != `val`) {
        nums(ans) = i
        ans += 1
      }
    ans
  }
}
