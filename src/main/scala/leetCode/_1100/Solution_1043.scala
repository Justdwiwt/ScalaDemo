package leetCode._1100

object Solution_1043 {
  def maxSumAfterPartitioning(A: Array[Int], K: Int): Int = A.indices./:(Seq(0))((q, i) => {
    val res = q.:\(A(i), 0, Int.MinValue) {
      case (prev, (mx, cnt, best)) =>
        val t = mx.max(A(i - cnt))
        (t, cnt + 1, best.max(prev + (cnt + 1) * t))
    }._3
    (q :+ res).takeRight(K)
  }).last
}
