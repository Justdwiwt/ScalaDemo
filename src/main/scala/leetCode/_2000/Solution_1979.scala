package leetCode._2000

object Solution_1979 {
  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def findGCD(nums: Array[Int]): Int =
    gcd(nums.min, nums.max)
}
