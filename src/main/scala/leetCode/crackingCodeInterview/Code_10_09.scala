package leetCode.crackingCodeInterview

object Code_10_09 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty) return false
    var i = 0
    var j = matrix.head.length - 1
    while (i < matrix.length && j >= 0) {
      if (matrix(i)(j) > target) j -= 1
      else if (matrix(i)(j) == target) return true
      else i += 1
    }
    false
  }
}
