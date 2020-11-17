package leetCode

object Solution_1030 {
  def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    val res = Array.ofDim[Int](R * C, 2)
    var idx = 0
    (0 until R).foreach(i => (0 until C).foreach(j => {
      res(idx) = Array(i, j)
      idx += 1
    }))
    java.util.Arrays.sort(res, (o1: Array[Int], o2: Array[Int]) => (o1.head - r0).abs + (o1(1) - c0).abs - (o2.head - r0).abs - (o2(1) - c0).abs)
    res
  }
}
