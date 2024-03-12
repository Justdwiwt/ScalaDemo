package leetCode._1700

object Solution_1619 {
  def trimMean(arr: Array[Int]): Double = {
    val start = (arr.length * 0.05).toInt
    val end = arr.length - (arr.length * 0.05).toInt
    arr.sorted.slice(start, end).sum / (end - start).toDouble
  }
}
