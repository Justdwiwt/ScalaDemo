package leetCode

object Solution_1370 {
  def sortString(s: String): String = {
    val mn = s.min.toInt - 'a'.toInt
    val mx = s.max.toInt - 'a'.toInt
    val arr = Array.fill[Int]('z'.toInt - 'a'.toInt + 1)(0)
    s.foreach(i => arr(i.toInt - 'a'.toInt) += 1)
    var res = ""
    while (res.length < s.length) {
      (mn to mx).foreach(i => if (arr(i) > 0) {
        res += (i + 'a'.toInt).toChar
        arr(i) -= 1
      })
      (mn to mx).reverse.foreach(i => if (arr(i) > 0) {
        res += (i + 'a'.toInt).toChar
        arr(i) -= 1
      })
    }
    res
  }
}
