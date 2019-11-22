package leetCode

object Solution_665 {
  def checkPossibility(nums: Array[Int]): Boolean = {
    var cnt = 1
    (1 until nums.length).foreach(i => {
      if (nums(i) < nums(i - 1)) {
        if (cnt == 0) return false
        if (i == 1 || nums(i) >= nums(i - 2)) nums(i - 1) = nums(i)
        else nums(i) = nums(i - 1)
        cnt -= 1
      }
    })
    true
  }
}
