package leetCode

object Solution_1921 {
  def eliminateMaximum(dist: Array[Int], speed: Array[Int]): Int = {
    var arr = Array.tabulate(dist.length)(i => (dist(i) + speed(i) - 1) / speed(i))
    arr = arr.sorted
    arr.indices.find(i => arr(i) <= i).getOrElse(arr.length)
  }
}
