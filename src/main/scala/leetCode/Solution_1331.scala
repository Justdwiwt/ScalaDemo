package leetCode

object Solution_1331 {
  def arrayRankTransform(arr: Array[Int]): Array[Int] = {
    val sorted = arr.sortBy(x => x).distinct.zipWithIndex.toMap
    arr.map(sorted(_) + 1)
  }
}
