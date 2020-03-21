package leetCode

object Solution_945 {
  def minIncrementForUnique(A: Array[Int]): Int = {
    val t = A.sorted
    var res = 0
    (0 until t.length - 1).foreach(i => {
      if (t(i) >= t(i + 1)) {
        res += t(i) - t(i + 1) + 1
        t(i + 1) = t(i) + 1
      }
    })
    res
  }
}
