package leetCode

object Solution_2293 {
  @scala.annotation.tailrec
  def minMaxGame(nums: Array[Int]): Int = {
    if (nums.length == 1) nums.head
    else minMaxGame((0 until nums.length / 2).map(i => {
      if (i % 2 == 0) nums(2 * i).min(nums(2 * i + 1))
      else nums(2 * i).max(nums(2 * i + 1))
    }).toArray)
  }
}
