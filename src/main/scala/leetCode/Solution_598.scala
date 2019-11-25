package leetCode

object Solution_598 {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    var a = m
    var b = n
    ops.foreach(i => {
      a = a.min(i(0))
      b = b.min(i(1))
    })
    a * b
  }
}
