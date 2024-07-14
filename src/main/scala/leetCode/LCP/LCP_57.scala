package leetCode.LCP

object LCP_57 {
  def getMaximumNumber(moles: Array[Array[Int]]): Int = {
    val maxNum = Array.fill(moles.length + 1)(0)
    val sorted = moles.sortBy(_.head)

    def distance(x1: Int, y1: Int, x2: Int, y2: Int): Int =
      (x1 - x2).abs + (y1 - y2).abs

    var mx = 0

    sorted.indices.foreach(k => {
      val kele = sorted(k)
      if (kele.head >= distance(kele(1), kele(2), 1, 1)) maxNum(k + 1) = 1
      (0.max(k - 10) until k).foreach(l => {
        val lele = sorted(l)
        if (maxNum(l + 1) > 0 && kele(0) - lele.head >= distance(kele(1), kele(2), lele(1), lele(2)))
          maxNum(k + 1) = maxNum(k + 1).max(maxNum(l + 1) + 1)
      })
      mx = mx.max(maxNum(k + 1))
    })
    mx
  }
}
