package leetCode._100

object Solution_87 {
  def isScramble(s1: String, s2: String): Boolean = {
    val cache = collection.mutable.Map.empty[(Int, Int, Int), Boolean]

    def f(i1: Int, i2: Int, len: Int): Boolean =
      if (len == 1) s1(i1) == s2(i2)
      else if (cache.contains((i1, i2, len))) cache((i1, i2, len))
      else (1 until len).exists(l1 => {
        lazy val l2 = len - l1
        val rc = f(i1, i2, l1) && f(i1 + l1, i2 + l1, l2) || f(i1, i2 + l1, l2) && f(i1 + l2, i2, l1)
        cache += ((i1, i2, len) -> rc)
        rc
      })

    f(0, 0, s1.length)
  }
}
