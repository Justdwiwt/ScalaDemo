package leetCode._1600

object Solution_1505 {
  def minInteger(num: String, k: Int): String = {
    val digitPositions = Array.fill[Int](10)(num.length)
    num.indices.foreach(i => {
      val a = num(i) - '0'
      digitPositions(a) = i.min(digitPositions(a))
    })
    val shifts = Array.ofDim[Int](10)
    val minNumSb = new StringBuilder
    var t = k
    var i = 0
    while (i < num.length) {
      var d = 0
      while (digitPositions(d) == num.length || digitPositions(d) - shifts(d) > t) d += 1
      val digit = d
      val digitChar = (digit + '0').toChar
      minNumSb.append(digitChar)
      t -= digitPositions(d) - shifts(d)
      d = 0
      while (d < 10) {
        if (digitPositions(d) >= digitPositions(digit)) shifts(d) += 1
        d += 1
      }
      var j = digitPositions(digit) + 1
      while (j < num.length && num(j) != digitChar) {
        val a = num(j) - '0'
        if (digitPositions(a) > j) shifts(digit) += 1
        j += 1
      }
      digitPositions(digit) = j
      i += 1
    }
    minNumSb.mkString
  }
}
