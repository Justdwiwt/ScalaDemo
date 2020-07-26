package leetCode

object Solution_329 {
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    if (matrix.isEmpty || matrix(0).isEmpty) return 0
    var res = 0
    val ori = matrix
    val memo = Array.ofDim[Int](matrix.length, matrix(0).length)

    def find(_curX: Int, _curY: Int): Int = {
      var top = 0
      var right = 0
      var down = 0
      var left = 0
      if (_curX - 1 >= 0 && ori(_curX)(_curY) < ori(_curX - 1)(_curY))
        if (memo(_curX - 1)(_curY) != 0) top = memo(_curX - 1)(_curY)
        else top = find(_curX - 1, _curY)
      if (_curY + 1 < ori(0).length && ori(_curX)(_curY) < ori(_curX)(_curY + 1))
        if (memo(_curX)(_curY + 1) != 0) right = memo(_curX)(_curY + 1)
        else right = find(_curX, _curY + 1)
      if (_curX + 1 < ori.length && ori(_curX)(_curY) < ori(_curX + 1)(_curY))
        if (memo(_curX + 1)(_curY) != 0) down = memo(_curX + 1)(_curY)
        else down = find(_curX + 1, _curY)
      if (_curY - 1 >= 0 && ori(_curX)(_curY) < ori(_curX)(_curY - 1))
        if (memo(_curX)(_curY - 1) != 0) left = memo(_curX)(_curY - 1)
        else left = find(_curX, _curY - 1)

      top.max(right).max(down.max(left)) + 1
    }

    matrix.indices.foreach(row => matrix(0).indices.foreach(col => res = res.max(find(row, col))))
    res
  }
}
