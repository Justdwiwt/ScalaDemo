package leetCode._4100

object Solution_4040 {
  def minOperations(nums: Array[Int], sum: Int): Int = {
    val inf = Int.MaxValue / 2

    val f = nums.foldLeft(Array.fill(sum + 1)(inf)) { (f, x) =>
      f(0) = 0
      val w = 32 - Integer.numberOfLeadingZeros(x)

      (sum to 1 by -1).foreach { i =>
        (0 until 32).takeWhile(a => (x.toLong << a) <= i).foreach(a => f(i) = f(i).min(f(i - (x << a)) + a))
        (w - 1 to 1 by -1).takeWhile(a => (x >> a) <= i).foreach(a => f(i) = f(i).min(f(i - (x >> a)) + a))
      }
      f
    }

    if (f(sum) == inf) -1 else f(sum)
  }
}
