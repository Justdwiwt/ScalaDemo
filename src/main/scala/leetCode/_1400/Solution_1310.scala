package leetCode._1400

object Solution_1310 {
  def xorQueries(arr: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    lazy val xor = arr.scanLeft(0)(_ ^ _)
    queries.map(x => xor(x.head) ^ xor(x(1) + 1))
  }
}
