package leetCode

object Code_17_24 {
  def getMaxMatrix(matrix: Array[Array[Int]]): Array[Int] = {
    val preSum = Array.fill(matrix.length + 1)(Array.fill(matrix.head.length + 1)(0))
    (1 to matrix.length)
      .foreach(i => (1 to matrix.head.length)
        .foreach(j => preSum(i)(j) = matrix(i - 1)(j - 1) + preSum(i - 1)(j) + preSum(i)(j - 1) - preSum(i - 1)(j - 1)))
    var mx = Int.MinValue
    val res = Array.fill(4)(0)
    matrix.indices.foreach(top => (top until matrix.length).foreach(bottom => {
      var localMax = 0
      var left = 0
      matrix.head.indices.foreach(right => {
        localMax = preSum(bottom + 1)(right + 1) + preSum(top)(left) - preSum(bottom + 1)(left) - preSum(top)(right + 1)
        if (mx < localMax) {
          mx = localMax
          res(0) = top
          res(1) = left
          res(2) = bottom
          res(3) = right
        }
        if (localMax < 0) {
          localMax = 0
          left = right + 1
        }
      })
    }))
    res
  }
}
