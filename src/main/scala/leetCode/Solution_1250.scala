package leetCode

object Solution_1250 {
  def isGoodArray(nums: Array[Int]): Boolean = {
    var res = nums(0)
    (1 until nums.length).foreach(i => res = gcd(res, nums(i)))
    res == 1
  }

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
