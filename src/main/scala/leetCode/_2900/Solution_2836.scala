package leetCode._2900

object Solution_2836 {
  def getMaxFunctionValue(receiver: List[Int], k: Long): Long = {
    val MxN = (1e5 + 10).toInt
    val MxM = 35
    val f = Array.fill(MxN, MxM)(0)
    val g = Array.fill(MxN, MxM)(0L)

    val n = receiver.length
    val a = Array.fill(n)(0)
    receiver.indices.foreach(i => a(i) = receiver(i))

    receiver.indices.foreach(i => {
      f(i)(0) = a(i)
      g(i)(0) = i + a(i)
    })

    var j = 1
    while (j < MxM && 1L << j <= k) {
      receiver.indices.foreach(i => {
        f(i)(j) = f(f(i)(j - 1))(j - 1)
        g(i)(j) = g(i)(j - 1) + g(f(i)(j - 1))(j - 1) - f(i)(j - 1)
      })
      j += 1
    }

    var res = 0L

    receiver.indices.foreach(i => {
      var p = i
      var cur = 0L
      var t = k
      while (t > 0) {
        val q = java.lang.Long.numberOfTrailingZeros(t)
        cur += g(p)(q) - p
        p = f(p)(q)
        t -= t & -t
      }
      res = res.max(cur + i)
    })

    res
  }

}
