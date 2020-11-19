package leetCode

object Solution_835 {
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    val arr = Array.ofDim[Int](A.length * 2 - 1, A.length * 2 - 1)
    A.indices.foreach(i => A.indices.foreach(j => if (A(i)(j) == 1)
      A.indices.foreach(x => A.indices.foreach(y => if (B(x)(y) == 1) arr(i - x + A.length - 1)(j - y + A.length - 1) += 1))))
    var res = 0
    (0 until A.length * 2 - 1).foreach(i => (0 until A.length * 2 - 1).foreach(j => res = res.max(arr(i)(j))))
    res
  }
}
