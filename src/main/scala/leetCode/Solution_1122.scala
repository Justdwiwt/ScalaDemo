package leetCode

object Solution_1122 {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val m = arr2.zipWithIndex.toMap
    arr1.map(x => m.getOrElse(x, 1000 + x)).zip(arr1).sortBy(_._1).map(_._2)
  }
}
