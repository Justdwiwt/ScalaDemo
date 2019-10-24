package leetCode

object Solution_169 {
  def majorityElement(nums: Array[Int]): Int = {
    var res = 0
    var cnt = 0
    nums.foreach(num =>
      if (cnt == 0) {
        res = num
        cnt += 1
      } else if (num == res) cnt += 1
      else cnt -= 1)
    res
  }
}
