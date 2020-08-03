package leetCode

object Solution_1521 {
  def closestToTarget(arr: Array[Int], target: Int): Int = {
    val M = 24
    val inf = 0x3f3f3f3f
    val neg = 0xcfcfcfcf

    def calc(bits: Array[Int]): Int = {
      var h = 1
      var res = 0
      bits.indices.foreach(i => {
        if (bits(i) == 0) res += h
        h <<= 1
      })
      res
    }

    val a = Array.ofDim[Int](arr.length, M)
    arr.indices.foreach(i => (0 until M).foreach(j => if ((arr(i) >> j & 1) == 0) a(i)(j) = 1))
    var min = neg
    var start = -1
    var cnt = Array.fill(M)(0)
    arr.indices.foreach(i => {
      (0 until M).foreach(j => cnt(j) += a(i)(j))
      var v = calc(cnt)
      while (v <= target) {
        min = min.max(v)
        start += 1
        (0 until M).foreach(j => cnt(j) -= a(start)(j))
        v = calc(cnt)
      }
    })
    cnt = Array.fill(M)(0)
    var max = inf
    start = -1
    arr.indices.foreach(i => {
      (0 until M).foreach(j => cnt(j) += a(i)(j))
      var v = calc(cnt)
      while (v < target) {
        start += 1
        (0 until M).foreach(j => cnt(j) -= a(start)(j))
        v = calc(cnt)
      }
      if (start < i) max = max.min(v)
    })
    (target - min).min(max - target)
  }
}
