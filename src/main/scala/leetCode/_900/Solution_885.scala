package leetCode._900

object Solution_885 {
  def spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    var res = Array[Array[Int]]()
    res :+= Array(r0, c0)
    var x = 0
    var y = 1
    var t = 0
    var k = 0
    var R0 = r0
    var C0 = c0
    while (res.length < R * C) {
      (0 until (k / 2 + 1)).foreach(_ => {
        R0 += x
        C0 += y
        if (R0 >= 0 && R0 < R && C0 > 0 && C0 < C) res :+= Array(R0, C0)
      })
      t = x
      x = y
      y = -t
      k += 1
    }
    res
  }
}
