package leetCode

object Solution_1031 {
  def maxSumTwoNoOverlap(A: Array[Int], L: Int, M: Int): Int = {
    (1 until A.length).foreach(i => A(i) += A(i - 1))
    var res = A(L + M - 1)
    var Lmx = A(L - 1)
    var Mmx = A(M - 1)
    (L + M until A.length).foreach(i => {
      Lmx = Lmx.max(A(i - M) - A(i - L - M))
      Mmx = Mmx.max(A(i - L) - A(i - L - M))
      res = res.max((Lmx + A(i) - A(i - M)).max(Mmx + A(i) - A(i - L)))
    })
    res
  }
}
