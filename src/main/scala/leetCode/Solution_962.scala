package leetCode

object Solution_962 {
  def maxWidthRamp(A: Array[Int]): Int = {
    val candidate = A.indices.flatMap(i => (i + 1 until A.length).withFilter(j => A(i) <= A(j)).map(j => j - i))
    if (candidate.isEmpty) 0 else candidate.max
  }

  def maxWidthRamp2(A: Array[Int]): Int = {
    var i = A.length - 1
    while (i > 0) {
      var left = 0
      var right = i
      while (right < A.length) {
        if (A(left) <= A(right)) return right - left
        else {
          left += 1
          right += 1
        }
      }
      i -= 1
    }
    0
  }
}
