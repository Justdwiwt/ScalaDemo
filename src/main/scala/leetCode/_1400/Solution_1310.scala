package leetCode._1400

object Solution_1310 {
  def xorQueries(arr: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val diff = Array.fill(arr.length + 1)(0)
    (1 to arr.length).foreach(i => diff(i) = diff(i - 1) ^ arr(i - 1))
    var res = Array.empty[Int]
    queries.foreach(i => res :+= (diff(i(0)) ^ diff(i(1) + 1)))
    res
  }
}
