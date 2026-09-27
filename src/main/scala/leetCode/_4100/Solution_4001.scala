package leetCode._4100

object Solution_4001 {
  def aggregateTimeSeries(series1: Array[Array[Int]], series2: Array[Array[Int]]): List[List[Int]] = {
    def loop(i: Int, j: Int): List[List[Int]] =
      if (i == series1.length && j == series2.length) Nil
      else {
        val t1 = if (i < series1.length) series1(i)(0) else Int.MaxValue
        val t2 = if (j < series2.length) series2(j)(0) else Int.MaxValue
        val t = t1.min(t2)

        val v1 =
          if (i < series1.length) series1(i)(1)
          else 0

        val v2 =
          if (j < series2.length) series2(j)(1)
          else 0

        List(t, v1 + v2) :: loop(if (t1 == t) i + 1 else i, if (t2 == t) j + 1 else j)
      }

    loop(0, 0)
  }
}
