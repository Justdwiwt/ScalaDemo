package leetCode

object Solution_1526 {
  def minNumberOperations(target: Array[Int]): Int = {
    var res = target.head
    (1 until target.length).foreach(i => if (target(i) > target(i - 1)) res += (target(i) - target(i - 1)))
    res
  }
}
