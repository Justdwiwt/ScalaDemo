package leetCode

object Solution_87 {
  def isScramble(s1: String, s2: String): Boolean = {
    val res = Array.ofDim[Boolean](s1.length + 1, s1.length, s1.length)
    s1.indices.foreach(i => s1.indices.withFilter(j => s1(i) == s2(j)).foreach(j => res(1)(i)(j) = true))
    (2 to s1.length).foreach(l => (0 to s1.length - l).foreach(i => (0 to s1.length - l).foreach(j => {
      var flag = false
      (1 until l).foreach(s => flag = flag || res(s)(i)(j) && res(l - s)(i + s)(j + s) || res(s)(i)(j + l - s) && res(l - s)(i + s)(j))
      res(l)(i)(j) = flag
    })))
    res(s1.length).head.head
  }
}
