package leetCode

object Solution_1502 {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    val t = arr.sorted
    val d = t(1) - t(0)
    (2 until arr.length).foreach(i => if (t(i) - t(i - 1) != d) return false)
    true
  }
}
