package leetCode

object Solution_1346 {
  def checkIfExist(arr: Array[Int]): Boolean = {
    arr.indices.foreach(i => arr.indices.foreach(j => if (arr(i) * 2 == arr(j) && i != j) return true))
    false
  }
}
