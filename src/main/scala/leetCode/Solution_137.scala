package leetCode

object Solution_137 {
  def singleNumber(nums: Array[Int]): Int = {
    var sum = 0
    var res = 0
    (0 until 32).foreach(i => {
      sum = 0
      nums.foreach(n => if ((n >> i & 1) != 0) sum += 1)
      if (sum % 3 != 0) res |= 1 << i
    })
    res
  }
}
