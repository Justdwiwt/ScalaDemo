package leetCode

object Solution_775 {
  def isIdealPermutation(A: Array[Int]): Boolean = {
    A.indices.foreach(i => if ((A(i) - i).abs > 1) return false)
    true
  }
}
