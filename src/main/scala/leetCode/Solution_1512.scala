package leetCode

object Solution_1512 {
  def numIdenticalPairs(nums: Array[Int]): Int = {
    var cnt = Array.fill(101)(0)
    var res = 0
    nums.foreach(i => {
      res += cnt(i)
      cnt(i) += 1
    })
    res
  }
}
