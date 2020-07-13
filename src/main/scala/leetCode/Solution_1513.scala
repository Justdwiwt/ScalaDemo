package leetCode

object Solution_1513 {
  def numSub(s: String): Int = {
    val M = 1000000007.toLong
    val t = Array.fill(s.length)(0L)
    t(s.length - 1) = if (s(s.length - 1) == '1') 1L else 0L
    (0 to s.length - 2).reverse.foreach(i => if (s(i) == '1') t(i) = 1L + t(i + 1))
    var res = 0L
    t.foreach(i => res = (res + i) % M)
    res.toInt
  }
}
