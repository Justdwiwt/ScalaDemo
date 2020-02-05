package leetCode

object Solution_796 {
  def rotateString(A: String, B: String): Boolean = (A.length == B.length) && (A + A).contains(B)
}
