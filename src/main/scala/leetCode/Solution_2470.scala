package leetCode


import scala.math.Integral.Implicits._

object Solution_2470 {
  @scala.annotation.tailrec
  def gcd[T: Integral](a: T, b: T): T = if (b == 0) a else gcd(b, a % b)

  def lcm[T: Integral](a: T, b: T): T = a / gcd(a, b) * b

  def subarrayLCM(nums: Array[Int], k: Int): Int = {
    def f(j: Int, currLcm: Int): Int =
      if (j == nums.length) 0
      else {
        val newLcm = lcm(currLcm, nums(j))
        if (newLcm > k) 0
        else if (newLcm == k) 1 + f(j + 1, newLcm)
        else f(j + 1, newLcm)
      }

    nums.indices./:(0)((cnt, i) => cnt + f(j = i, currLcm = 1))
  }
}
