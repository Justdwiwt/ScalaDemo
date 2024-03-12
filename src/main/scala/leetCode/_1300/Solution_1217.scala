package leetCode._1300

object Solution_1217 {
  def minCostToMoveChips(chips: Array[Int]): Int = chips./:(List(0, 0))((l, p) => {
    if (p % 2 == 0) List(l.head, l(1) + 1) else List(l.head + 1, l(1))
  }).min
}
