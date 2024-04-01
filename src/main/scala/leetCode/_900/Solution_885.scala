package leetCode._900

object Solution_885 {
  def spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array[Array[Int]] = {
    val matrix = Array.fill(rows * cols, 2)(0)
    val dir = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
    var idx = 0
    matrix(idx) = Array(rStart, cStart)
    idx += 1
    var len = 0
    var d = 0
    var rs = rStart
    var cs = cStart
    while (idx < rows * cols) {
      if (d == 0 || d == 2) len += 1
      (0 until len).foreach(_ => {
        rs += dir(d).head
        cs += dir(d)(1)
        if (rs >= 0 && rs < rows && cs >= 0 && cs < cols) {
          matrix(idx) = Array(rs, cs)
          idx += 1
        }
      })
      d = (d + 1) % 4
    }
    matrix
  }
}
