package leetCode._2200

object Solution_2117 {
  def abbreviateProduct(left: Int, right: Int): String = {
    val M = 1e12.toLong
    var (pre, suf, c) = (1L, 1L, 0L)
    (left.toLong until (right + 1).toLong).foreach(n => {
      pre *= n
      suf *= n
      while (suf % 10 == 0) {
        c += 1
        suf /= 10
      }
      if (suf > M) suf = suf % M
      while (pre > M) pre /= 10
    })
    if (suf < 10000000000L) suf.toString + "e" + c
    else pre.toString.take(5) + "..." + suf.toString.takeRight(5) + "e" + c
  }
}
