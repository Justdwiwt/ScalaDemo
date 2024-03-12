package leetCode._2000

object Solution_1975 {
  def maxMatrixSum(matrix: Array[Array[Int]]): Long = {
    var sum = 0L
    var mn = Int.MaxValue
    var neg = 0
    matrix.indices.foreach(i => matrix.indices.foreach(j => {
      sum += matrix(i)(j).abs
      if (matrix(i)(j) < 0) neg += 1
      mn = mn.min(matrix(i)(j).abs)
    }))
    if (neg % 2 == 1) sum -= 2L * mn
    sum
  }
}
