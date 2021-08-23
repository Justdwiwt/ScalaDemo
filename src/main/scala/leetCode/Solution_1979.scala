package leetCode

object Solution_1979 {
  def findGCD(nums: Array[Int]): Int = {
    var mn = Int.MaxValue
    var mx = 0
    nums.foreach(x => {
      mn = mn.min(x)
      mx = mx.max(x)
    })
    gcd(mn, mx)
  }

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) return a
    gcd(b, a % b)
  }
}
