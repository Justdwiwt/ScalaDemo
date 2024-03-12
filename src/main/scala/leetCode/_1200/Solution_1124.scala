package leetCode._1200

object Solution_1124 {
  def longestWPI(hours: Array[Int]): Int = {
    var res = 0
    val A = hours.map(x => if (x > 8) 1 else -1)
    val B = Array.fill(A.length)(0)
    B(0) = A(0)
    A.indices.tail.foreach(i => B(i) = B(i - 1) + A(i))
    B.indices.foreach(i => if (B(i) > 0) res = i + 1)
    B.indices.foreach(i => (i + 1 until B.length).withFilter(j => B(j) - B(i) > 0).foreach(j => res = res.max(j - i)))
    res
  }
}
