package leetCode

object Solution_1413 {
  def minStartValue(nums: Array[Int]): Int = {
    var res = 1
    var sum = 0
    nums.indices.foreach(i => {
      sum += nums(i)
      if (sum + res < 1) res = 1 - sum
    })
    res
  }
}
