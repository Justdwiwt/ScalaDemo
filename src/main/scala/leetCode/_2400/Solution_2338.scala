package leetCode._2400

import scala.collection.mutable.ArrayBuffer

object Solution_2338 {
  val M = 1000000007
  var inv: ArrayBuffer[Long] = _

  private def C(a: Int, b: Int): Long = {
    if (b > a) return 0
    var ret = 1L
    (1 to b).foreach(i => ret = (ret * (a - i + 1) % M * inv(i)) % M)
    ret
  }

  def idealArrays(n: Int, K: Int): Int = {
    val f: Array[ArrayBuffer[Int]] = Array.fill(K + 1)(ArrayBuffer.empty[Int])
    var mx = 0
    (2 to K).foreach(i => if (f(i).isEmpty) {
      var j = i
      while (j <= K) {
        var x = j
        var y = 0
        while (x % i == 0) {
          y += 1
          x /= i
        }
        f(j).append(y)
        mx = mx.max(y)
        j += i
      }
    })

    inv = ArrayBuffer.fill(mx + 5)(0)
    inv(1) = 1
    (2 to mx).foreach(i => inv(i) = (M - M / i) * inv(M % i) % M)

    var res = 0L
    (1 to K).foreach(i => {
      var t = 1L
      f(i).foreach(x => t = (t * C(n + x - 1, x)) % M)
      res = (res + t) % M
    })
    res.toInt
  }
}
