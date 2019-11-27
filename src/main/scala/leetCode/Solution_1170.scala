package leetCode

object Solution_1170 {
  def numSmallerByFrequency(queries: Array[String], words: Array[String]): Array[Int] = {
    val res = Array.fill(queries.length)(0)
    queries.indices.foreach(i => {
      val cnt = countMin(queries(i))
      words.foreach(c => if (cnt < countMin(c)) res(i) += 1)
    })
    res
  }

  def countMin(s: String): Int = {
    var mn = s(0)
    var cnt = 0
    s.indices.foreach(i => {
      if (s(i) < mn) {
        mn = s(i)
        cnt = 0
      }
      if (s(i) == mn) cnt += 1
    })
    cnt
  }
}
