package leetCode._4100

object Solution_4035 {
  def maxValidSplits(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) math.abs(a) else gcd(b, a % b)

    (-1 until nums.length).map { i =>
      val arr = nums.indices.filter(_ != i).map(nums).toVector

      if (arr.length < 2) 0
      else {
        val prefix = arr.scanLeft(0)(gcd).tail
        val suffix = arr.scanRight(0)(gcd).init

        prefix.zip(suffix.tail).count { case (a, b) => a == b }
      }
    }.max
  }
}
