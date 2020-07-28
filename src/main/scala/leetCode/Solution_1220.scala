package leetCode

object Solution_1220 {
  def countVowelPermutation(n: Int): Int = {
    val M = (1e9 + 7).toLong
    var a = 1L
    var e = 1L
    var i = 1L
    var o = 1L
    var u = 1L
    (2 to n).foreach(_ => {
      val aa = (e + i + u) % M
      val ee = (a + i) % M
      val ii = (e + o) % M
      val oo = i
      val uu = (o + i) % M
      a = aa
      e = ee
      i = ii
      o = oo
      u = uu
    })
    ((a + e + i + o + u) % M).toInt
  }
}
