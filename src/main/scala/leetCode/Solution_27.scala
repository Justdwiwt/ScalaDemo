package leetCode

object Solution_27 {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var ans = 0
    nums.foreach(i =>
      if (i != `val`) {
        nums(ans) = i
        ans += 1
      })
    ans
  }
}
