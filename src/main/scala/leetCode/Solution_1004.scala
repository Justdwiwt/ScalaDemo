package leetCode

object Solution_1004 {
  def longestOnes(A: Array[Int], K: Int): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int, cur: Int, i: Int, mx: Int): Int =
      if (r == A.length) mx
      else if (A(r) == 1) f(l, r + 1, cur + 1, i, mx.max(cur + 1))
      else if (i > 0) f(l, r + 1, cur + 1, i - 1, mx.max(cur + 1))
      else if (A(l) == 0) f(l + 1, r.max(l + 1), 0.max(cur - 1), K.min(i + 1), mx)
      else f(l + 1, r.max(l + 1), 0.max(cur - 1), i, mx)

    f(0, 0, 0, K, 0)
  }
}
