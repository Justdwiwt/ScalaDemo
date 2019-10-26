package leetCode

object Solution_941 {
  def validMountainArray(A: Array[Int]): Boolean = {
    if (A.length == 0) return false
    val peak = A.indexOf(A.max)
    if (peak == 0 || peak == A.length - 1) return false
    A.indices.dropRight(1).foreach(i => {
      if (i < peak && A(i) >= A(i + 1)) return false
      if (i > peak && A(i) <= A(i + 1)) return false
      if (i == peak && A(i) == A(i + 1)) return false
    })
    true
  }
}
