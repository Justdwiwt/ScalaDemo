package leetCode

object Solution_1819 {
  def countDifferentSubsequenceGCDs(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    val max = nums.max
    val numSet = nums.toSet
    (1 to max).count(x => (x to max by x).filter(numSet.contains).fold(0)(gcd) == x)
  }
}
