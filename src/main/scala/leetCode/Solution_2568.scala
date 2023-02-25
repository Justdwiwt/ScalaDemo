package leetCode

object Solution_2568 {
  def minImpossibleOR(nums: Array[Int]): Int = {
    var res = 0
    nums.foreach(n => if ((n & (n - 1)) == 0) res |= n)
    res = ~res
    res & -res
  }
}
