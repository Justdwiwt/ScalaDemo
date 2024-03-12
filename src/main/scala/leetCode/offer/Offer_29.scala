package leetCode.offer

object Offer_29 {
  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.isEmpty || matrix(0).isEmpty) return Array.empty
    var i = 0
    var j = 0
    var idx = 0
    var res = Array.empty[Int]
    val dir = Array(Array(0, 1), Array(1, 0), Array(0, -1), Array(-1, 0))
    (0 until (matrix.length * matrix(0).length)).foreach(_ => {
      res :+= matrix(i)(j)
      matrix(i)(j) = 0
      var x = i + dir(idx).head
      var y = j + dir(idx)(1)
      if (x < 0 || x >= matrix.length || y < 0 || y >= matrix(0).length || matrix(x)(y) == 0) {
        idx = (idx + 1) % 4
        x = i + dir(idx).head
        y = j + dir(idx)(1)
      }
      i = x
      j = y
    })
    res
  }
}
