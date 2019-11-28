package leetCode

object Solution_54 {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    if (matrix.isEmpty || matrix(0).isEmpty) return List.empty
    var i = 0
    var j = 0
    var index = 0
    var res = List[Int]()
    val dirs = List(List(0, 1), List(1, 0), List(0, -1), List(-1, 0))
    (0 until (matrix.length * matrix(0).length)).foreach(_ => {
      res :+= matrix(i)(j)
      matrix(i)(j) = 0
      var x = i + dirs(index).head
      var y = j + dirs(index)(1)
      if (x < 0 || x >= matrix.length || y < 0 || y >= matrix(0).length || matrix(x)(y) == 0) {
        index = (index + 1) % 4
        x = i + dirs(index).head
        y = j + dirs(index)(1)
      }
      i = x
      j = y
    })
    res
  }
}
