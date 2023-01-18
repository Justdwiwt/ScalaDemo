package leetCode

object Solution_2536 {
  def rangeAddQueries(n: Int, queries: Array[Array[Int]]): Array[Array[Int]] = {
    val arr = Array.fill(n)(new Array[Int](n))
    queries.foreach(q => (q.head to q(2)).foreach(i => (q(1) to q(3)).foreach(j => arr(i)(j) += 1)))
    arr
  }
}
