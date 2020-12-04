package leetCode

object Solution_1550 {
  def threeConsecutiveOdds(arr: Array[Int]): Boolean = {
    arr.sliding(3, 1).exists(_.map(_ % 2).count(_ == 1) == 3)
  }
}
