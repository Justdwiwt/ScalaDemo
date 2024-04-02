package leetCode._800

object Solution_775 {
  def isIdealPermutation(A: Array[Int]): Boolean =
    A.indices.forall(i => (A(i) - i).abs <= 1)
}
