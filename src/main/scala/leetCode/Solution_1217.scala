package leetCode

object Solution_1217 {
  def minCostToMoveChips(chips: Array[Int]): Int = {
    var odd = 0
    var even = 0
    chips.foreach(i => if ((i & 1) == 0) even += 1 else odd += 1)
    even.min(odd)
  }
}
