package leetCode._1400

object Solution_1304 {
  def sumZero(n: Int): Array[Int] = {
    (1 - n until n by 2).toArray
  }
}
