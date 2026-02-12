package leetCode._3900

object Solution_3821 {
  private val MAX = 50

  private val C: Array[Array[Long]] = (0 to MAX).foldLeft(Array.fill(MAX + 1, MAX + 1)(0L))((c, i) => {
    c(i)(0) = 1
    c(i)(i) = 1
    (1 until i).foreach(j => c(i)(j) = c(i - 1)(j - 1) + c(i - 1)(j))
    c
  })

  def nthSmallest(n: Long, k: Int): Long = (49 to 0 by -1).foldLeft((n, k, 0L)) {
    case ((remain, ones, ans), i) if ones > 0 =>
      val cnt = if (i >= ones) C(i)(ones) else 0L
      if (remain > cnt) (remain - cnt, ones - 1, ans | (1L << i))
      else (remain, ones, ans)
    case (state, _) => state
  }._3
}
