package leetCode._1100

import scala.collection.mutable

object Solution_1074 {
  def numSubmatrixSumTarget(matrix: Array[Array[Int]], target: Int): Int = {
    if (matrix.length == 1 && matrix(0).length == 1) return if (matrix(0)(0) == target) 1 else 0
    var res = 0
    val arr = Array.ofDim[Int](matrix.length, matrix(0).length + 1)
    matrix.indices.foreach(i => (1 to matrix(0).length).foreach(j => arr(i)(j) = arr(i)(j - 1) + matrix(i)(j - 1)))
    (1 to matrix(0).length).foreach(i => (i to matrix(0).length).foreach(j => {
      var sum = 0
      val m = mutable.Map[Int, Int]()
      m += 0 -> 1
      matrix.indices.foreach(k => {
        sum += arr(k)(j) - arr(k)(i - 1)
        res += m.getOrElse(sum - target, 0)
        m += sum -> (m.getOrElse(sum, 0) + 1)
      })
    }))
    res
  }
}
