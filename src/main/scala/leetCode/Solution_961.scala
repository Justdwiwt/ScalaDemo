package leetCode

object Solution_961 {
  def repeatedNTimes(A: Array[Int]): Int = {
    val t = A.sorted
    if (t(t.length / 2) == t(t.length - 1)) t(t.length / 2) else t(t.length / 2 - 1)
  }
}
