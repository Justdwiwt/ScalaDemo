package leetCode

object Solution_3012 {
  def minimumArrayLength(nums: Array[Int]): Int = {
    val g = nums.reduce(gcd)
    (1.max(nums.count(_ == g)) + 1) / 2
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
