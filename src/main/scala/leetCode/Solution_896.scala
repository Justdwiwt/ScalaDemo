package leetCode

object Solution_896 {
  def isMonotonic(A: Array[Int]): Boolean = {
    val res = true
    var flag = 0
    (0 until A.length - 1).foreach(i =>
      if (A(i) > A(i + 1)) {
        if (flag == 0) flag = 2
        else if (flag == 1) return false
      } else if (A(i) < A(i + 1))
        if (flag == 0) flag = 1
        else if (flag == 2) return false)
    res
  }
}
