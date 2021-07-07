package leetCode

object Solution_1338 {
  def minSetSize(arr: Array[Int]): Int = arr
    .groupBy(c => c)
    .map(_._2.length)
    .toSeq
    .sortWith(_ > _)
    .scanLeft(0)(_ + _)
    .indexWhere(_ >= arr.length / 2)
}
