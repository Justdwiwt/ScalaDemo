package leetCode._100

object Solution_44 {
  def isMatch(s: String, p: String): Boolean = {
    val arr = f(s, p)
    (1 to s.length).foreach(i => (1 to p.length).foreach(j => p(j - 1) match {
      case c if c == s(i - 1) || c == '?' => arr(i)(j) = arr(i - 1)(j - 1)
      case '*' => arr(i)(j) = arr(i - 1)(j - 1) || arr(i - 1)(j) || arr(i)(j - 1)
      case _ =>
    }))
    arr(s.length)(p.length)
  }

  def f(s: String, p: String): Array[Array[Boolean]] = {
    val arr = Array.fill(s.length + 1)(Array.ofDim[Boolean](p.length + 1))
    arr(0)(0) = true
    p.indices.withFilter(i => p(i) == '*').foreach(i => arr(0)(i + 1) = arr(0)(i))
    arr
  }
}
