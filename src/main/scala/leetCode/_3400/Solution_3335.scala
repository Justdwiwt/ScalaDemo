package leetCode._3400

object Solution_3335 {
  val M = 1000000007

  def lengthAfterTransformations(s: String, t: Int): Int = {
    val cnt = s.foldLeft(Array.fill(26)(0L))((cnt, c) => cnt.updated(c - 'a', cnt(c - 'a') + 1))

    val res = (1 to t).foldLeft(cnt)((cnt, _) => {
      val nxt = Array.fill(26)(0L)
      (0 until 25).foreach(j => nxt(j + 1) = cnt(j) % M)
      nxt(0) = (cnt(25) + nxt(0)) % M
      nxt(1) = (cnt(25) + nxt(1)) % M
      nxt
    })

    (res.sum % M).toInt
  }
}
