package leetCode

object Solution_972 {
  def isRationalEqual(S: String, T: String): Boolean = {
    val M = 1e-8
    (func(S) - func(T)).abs <= M
  }

  def func(S: String): Double = {
    if (S.contains("(")) {
      val dot = S.indexOf(".")
      val l = S.indexOf("(")
      val r = S.indexOf(")")
      val p = S.split('(').head.toDouble
      val p2 = S.substring(l + 1, r).toDouble / Array.fill(r - l - 1)("9").reduce(_ + _).toDouble / math.pow(10, l - dot - 1)
      p + p2
    } else S.toDouble
  }
}
