package leetCode._3900

object Solution_3867 {
  def gcdSum(nums: Array[Int]): Long = {
    @scala.annotation.tailrec
    def gcd(x: Int, y: Int): Int =
      if (x == 0) y else gcd(y % x, x)

    val t = nums.scanLeft(nums.head)(_.max(_)).tail
    val t1 = t.zip(nums).map(n => gcd(n._1, n._2)).sorted
    val n = t1.length
    t1.zip(t1.reverse).map(n => gcd(n._1, n._2)).map(_.toLong).take(n / 2).sum
  }
}
