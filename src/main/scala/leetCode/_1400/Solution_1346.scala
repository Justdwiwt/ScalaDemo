package leetCode._1400

object Solution_1346 {
  def checkIfExist(arr: Array[Int]): Boolean = {
    if (arr.count(_ == 0) > 1) return true
    arr.filter(_ != 0).map(2 * _).exists(arr.contains)
  }
}
