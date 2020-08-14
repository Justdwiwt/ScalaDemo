package leetCode

object Solution_396 {
  def maxRotateFunction(A: Array[Int]): Int = {
    var F = 0
    var sum = 0
    A.indices.foreach(i => {
      sum += A(i)
      F += i * A(i)
    })
    var res = F
    (1 until A.length).foreach(i => {
      F += (sum - A.length * A(A.length - i))
      res = res.max(F)
    })
    res
  }
}
