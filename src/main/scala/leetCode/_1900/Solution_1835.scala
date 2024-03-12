package leetCode._1900

object Solution_1835 {
  def getXORSum(arr1: Array[Int], arr2: Array[Int]): Int =
    arr1.reduce((x, y) => x ^ y) & arr2.reduce((x, y) => x ^ y)
}
