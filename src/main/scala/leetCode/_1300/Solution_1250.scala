package leetCode._1300

object Solution_1250 {
  def isGoodArray(nums: Array[Int]): Boolean = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    nums.reduce(gcd) == 1
  }
}
