package leetCode

object Solution_2529 {
  def maximumCount(nums: Array[Int]): Int = {
    var pos = 0
    var neg = 0
    nums.foreach(n => {
      if (n > 0) pos += 1
      else if (n < 0) neg += 1
    })
    pos.max(neg)
  }
}
