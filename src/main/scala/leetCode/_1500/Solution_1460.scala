package leetCode._1500

object Solution_1460 {
  def canBeEqual(target: Array[Int], arr: Array[Int]): Boolean = {
    target.intersect(arr).length == target.length
  }
}
