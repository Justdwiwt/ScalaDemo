package leetCode._800

object Solution_712 {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    val m = collection.mutable.Map.empty[(Int, Int), Int]

    def f(i1: Int, i2: Int): Int =
      if (i1 >= s1.length) (i2 until s2.length).map(s2).sum
      else if (i2 >= s2.length) (i1 until s1.length).map(s1).sum
      else if (m.contains(i1, i2)) m(i1, i2)
      else {
        lazy val rc = if (s1(i1) == s2(i2)) f(i1 + 1, i2 + 1) else (f(i1, i2 + 1) + s2(i2)).min(f(i1 + 1, i2) + s1(i1))
        m += ((i1, i2) -> rc)
        rc
      }

    f(0, 0)
  }
}
