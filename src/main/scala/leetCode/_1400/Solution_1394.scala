package leetCode._1400

object Solution_1394 {
  def findLucky(arr: Array[Int]): Int = arr
    .zip(arr.map(x => arr.count(_ == x)))
    .map(x => if (x._1 == x._2) x._1 else -1)
    .max
}
