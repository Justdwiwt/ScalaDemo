package leetCode

object Solution_2344 {
  def minOperations(nums: Array[Int], numsDivide: Array[Int]): Int = {
    val g = numsDivide.reduce(gcd)
    nums.sorted.indexWhere(n => {
      if (n > g) return -1
      g % n == 0
    })
  }

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)
}
