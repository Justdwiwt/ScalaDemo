package leetCode._3300

object Solution_3290 {
  def maxScore(a: Array[Int], b: Array[Int]): Long = {
    val arr = Array.fill(5)(Long.MinValue / 2).updated(0, 0L)
    b.foldLeft(arr)((f, y) => (3 to 0 by -1).foldLeft(f)((cur, j) => cur.updated(j + 1, cur(j + 1).max(cur(j) + a(j).toLong * y))))(4)
  }
}
