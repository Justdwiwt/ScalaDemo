package leetCode._1200

object Solution_1122 {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] =
    arr1.sortBy(n => if (arr2.contains(n)) arr2.indexOf(n) else n + arr1.length)
}
