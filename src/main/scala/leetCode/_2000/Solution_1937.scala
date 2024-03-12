package leetCode._2000

object Solution_1937 {
  def maxPoints(points: Array[Array[Int]]): Long = {
    var res = points.head.map(_.toLong)
    points.indices.drop(1).foreach(row => {
      res.indices.drop(1).foreach(col => res(col) = res(col).max(res(col - 1) - 1))
      (0 until res.length - 1).reverse.foreach(col => res(col) = res(col).max(res(col + 1) - 1))
      res = Array.tabulate(res.length)(col => points(row)(col) + res(col))
    })
    res.max
  }
}
