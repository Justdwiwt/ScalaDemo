package leetCode._3400

object Solution_3344 {
  private def cal(n: Int): Double = {
    if (n == 0) 0.0
    else {
      val res = (0 to n).foldLeft(Array.fill(32)(0))((acc, j) => {
        (0 until 32).foreach(i => if (((1 << i) & j) != 0) acc(i) += 1)
        acc
      })

      val sum = (0 until 32).foldLeft(0L) { (acc, i) =>
        val c0 = n + 1 - res(i)
        val c1 = res(i)
        res(i) = c0 * res(i) + c1 * (n + 1)
        acc + res(i) * (1 << i)
      }

      (n * n + n) * sum / 2.0
    }
  }

  @scala.annotation.tailrec
  private def binarySearch(left: Int, right: Int, s: Long): Int =
    if (left > right) right
    else {
      val mid = (left + right) / 2
      if (cal(mid).toLong > s) binarySearch(left, mid - 1, s)
      else binarySearch(mid + 1, right, s)
    }

  def maxSizedArray(s: Long): Int =
    binarySearch(0, 1200, s) + 1
}
