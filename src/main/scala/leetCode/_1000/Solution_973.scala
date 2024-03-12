package leetCode._1000

object Solution_973 {
  def distance(x: Int, y: Int): Int = x * x + y * y

  def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    points.sortBy(arr => distance(arr(0), arr(1))).take(K)
  }
}
