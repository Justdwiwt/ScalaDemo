package leetCode

object Solution_2564 {
  def substringXorQueries(s: String, queries: Array[Array[Int]]): Array[Array[Int]] = {
    val res = Array.fill(queries.length)(new Array[Int](2))
    queries.indices.foreach(j => {
      val x = (queries(j).head ^ queries(j)(1)).toBinaryString
      val i = s.indexOf(x)
      if (i < 0) {
        res(j)(0) = -1
        res(j)(1) = -1
      } else {
        res(j)(0) = i
        res(j)(1) = x.length + i - 1
      }
    })
    res
  }
}
