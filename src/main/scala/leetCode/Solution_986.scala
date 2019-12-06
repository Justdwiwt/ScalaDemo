package leetCode

object Solution_986 {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    var res = Array.empty[Array[Int]]
    var i = 0
    var j = 0
    while (i < A.length && j < B.length) {
      val left = A(i)(0).max(B(j)(0))
      val right = A(i)(1).min(B(j)(1))
      if (left <= right) res :+= Array(left, right)
      if (A(i)(1) >= B(j)(1)) j += 1 else i += 1
    }
    res
  }
}
