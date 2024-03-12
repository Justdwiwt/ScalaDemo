package leetCode._1700

object Solution_1636 {
  def frequencySort(nums: Array[Int]): Array[Int] = nums
    .groupBy(identity)
    .map({ case (k, v) => (k, v.length) })
    .toArray
    .sortWith((a, b) => a._2 < b._2 || (a._2 == b._2 && a._1 > b._1))
    .flatMap({ case (k, v) => Array.fill(v)(k) })
}
