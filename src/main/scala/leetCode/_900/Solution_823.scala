package leetCode._900

object Solution_823 {
  def numFactoredBinaryTrees(A: Array[Int]): Int = {
    var m = Map.empty[Int, Long].withDefaultValue(0L)
    A.sorted.foreach(a => {
      val v = m
        .keys
        .filter(a % _ == 0)
        ./:(1L)((x, y) => x + m(y) * m.getOrElse(a / y, 0L))
      m += (a -> v)
    })
    (m.values.sum % 1000000007L).toInt
  }
}
