package leetCode._1400

object Solution_1394 {
  def findLucky(arr: Array[Int]): Int = {
    val filtered = arr.groupBy(identity).mapValues(_.length).filter(v => v._1 == v._2)
    if (filtered.isEmpty) -1 else filtered.keys.max
  }
}
