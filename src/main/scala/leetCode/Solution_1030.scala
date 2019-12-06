package leetCode

object Solution_1030 {
  def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    var max = 0
    var xy = Array.fill(2)(0)
    var res = Array.empty[Array[Int]]
    xy(0) = r0
    xy(1) = c0
    res :+= xy
    if (R - 1 - r0 > r0) max = R - 1 - r0 else max = r0
    if (C - 1 - c0 > c0) max += (C - 1 - c0) else max += c0
    (1 to max).foreach(k => (0 to k).foreach(i => {
      val j = k - i
      if (r0 - i >= 0 && c0 - j >= 0) {
        xy(0) = r0 - i
        xy(1) = c0 - j
        res :+= xy
      }
      if (r0 - i >= 0 && c0 + j < C && j > 0) {
        xy(0) = r0 - i
        xy(1) = c0 + j
        res :+= xy
      }
      if (r0 + i < R && c0 - j >= 0 && i > 0) {
        xy(0) = r0 + i
        xy(1) = c0 - j
        res :+= xy
      }
      if (r0 + i < R && c0 + j < C && i * j > 0) {
        xy(0) = r0 + i
        xy(1) = c0 + j
        res :+= xy
      }
    }))
    res
  }
}
