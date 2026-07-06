package leetCode._4000

object Solution_3937 {
  def minOperations(nums: Array[Int], k: Int): Int = {
    val evens = nums.sliding(1, 2).map(_.head % k).toSeq
    val odds = nums.tail.sliding(1, 2).map(_.head % k).toSeq

    def oper(arr: Seq[Int], x: Int): Int =
      arr.map(m => if (m > x) (m - x).min(x + k - m) else (x - m).min(m + k - x)).sum

    (0 until k).combinations(2).map { case Seq(x, y) => (oper(odds, x) + oper(evens, y)).min(oper(evens, x) + oper(odds, y)) }.min
  }
}
