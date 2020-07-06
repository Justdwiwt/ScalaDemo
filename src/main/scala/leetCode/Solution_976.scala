package leetCode

object Solution_976 {
  def largestPerimeter(A: Array[Int]): Int = {
    if (A == null || A.length < 3) return 0
    val t = A.sorted
    (t.length - 1 to 2 by (-1)).foreach(i => if (t(i - 1) + t(i - 2) > t(i)) return t(i) + t(i - 1) + t(i - 2))
    0
  }
}
