package leetCode

object Solution_1558 {
  def minOperations(nums: Array[Int]): Int = {
    var res = 0
    var mx = 0
    nums.foreach(n => {
      mx = mx.max(n)
      res += Integer.bitCount(n)
    })
    res += Integer.toBinaryString(mx).length - 1
    res
  }
}
