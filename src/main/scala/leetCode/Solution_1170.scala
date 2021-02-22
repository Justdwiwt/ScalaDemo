package leetCode

object Solution_1170 {
  def f(w: String): Int = {
    val arr = w.toArray
    arr.count(x => x == arr.min)
  }

  def numSmallerByFrequency(queries: Array[String], words: Array[String]): Array[Int] = {
    val arr = words./:(new Array[Int](11))((x, y) => {
      val t = f(y)
      x.update(t, x(t) + 1)
      x
    })
    queries.map(x => arr.takeRight(10 - f(x)).sum)
  }
}
