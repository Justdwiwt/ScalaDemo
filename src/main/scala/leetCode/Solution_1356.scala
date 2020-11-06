package leetCode

object Solution_1356 {
  def sortByBits(arr: Array[Int]): Array[Int] = {
    arr.sortBy(x => Integer.bitCount(x) -> x)
  }
}
