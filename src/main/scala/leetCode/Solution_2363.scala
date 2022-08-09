package leetCode

object Solution_2363 {
  def mergeSimilarItems(items1: Array[Array[Int]], items2: Array[Array[Int]]): List[List[Int]] = (items1 ++ items2)
    .map(_.toList)
    .groupBy(_.head)
    .map(n => (n._1, n._2.map(m => m.last).sum))
    .toList
    .sortBy(n => (n._1, n._2))
    .map(n => List(n._1, n._2))
}
