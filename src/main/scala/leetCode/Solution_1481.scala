package leetCode

object Solution_1481 {
  def findLeastNumOfUniqueInts(arr: Array[Int], k: Int): Int = arr
    .groupBy(x => x)
    .values
    .map(x => (x.head, x.length))
    .toList
    .sortWith(_._2 < _._2)
    .flatMap(x => Array.fill(x._2)(x._1))
    .drop(k)
    .groupBy(x => x)
    .keySet
    .size
}
