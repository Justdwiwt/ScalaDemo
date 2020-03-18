package leetCode

object Solution_836 {
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = rec1(2).min(rec2(2)) > rec1(0).max(rec2(0)) && rec1(3).min(rec2(3)) > rec1(1).max(rec2(1))
}
