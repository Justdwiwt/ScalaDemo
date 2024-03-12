package leetCode._1000

object Solution_905 {
  def sortArrayByParity(A: Array[Int]): Array[Int] =
    A.groupBy(_ % 2 != 0).values.flatten.toArray
}
