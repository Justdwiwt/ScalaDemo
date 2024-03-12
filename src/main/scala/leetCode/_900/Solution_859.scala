package leetCode._900

object Solution_859 {
  def buddyStrings(A: String, B: String): Boolean =
    if (A.length != B.length) false
    else {
      val diff = A.indices.filter(i => A(i) != B(i))
      (diff.isEmpty && A.length > A.toSet.size) || (diff.length == 2 && diff.map(A(_)) == diff.map(B(_)).reverse)
    }
}
