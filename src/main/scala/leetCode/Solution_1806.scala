package leetCode

object Solution_1806 {
  @scala.annotation.tailrec
  def reinitializePermutation(n: Int, r: Int = 1, p: Int = 2): Int =
    if (n == 2) 1
    else if (p == 1) r
    else reinitializePermutation(n, r + 1, p * 2 % (n - 1))
}
