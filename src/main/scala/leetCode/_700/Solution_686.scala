package leetCode._700

object Solution_686 {
  def repeatedStringMatch(A: String, B: String): Int = {
    f(1, A, B, A)
  }

  @scala.annotation.tailrec
  def f(cnt: Int, exA: String, B: String, A: String): Int = {
    if (exA.length - B.length > 2 * A.length) -1
    else if (exA.containsSlice(B)) cnt
    else f(cnt + 1, A + exA, B, A)
  }
}
