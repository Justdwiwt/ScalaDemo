package leetCode

object Solution_427 {

  class Node(var _value: Int, var _isLeaf: Boolean,
             var _topLeft: Node,
             var _topRight: Node,
             var _bottomLeft: Node,
             var _bottomRight: Node) {
    var value: Int = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = _topLeft
    var topRight: Node = _topRight
    var bottomLeft: Node = _bottomLeft
    var bottomRight: Node = _bottomRight
  }

  def construct(grid: Array[Array[Int]]): Node = {

    def f(grid: Array[Array[Int]], x: Int, y: Int, offset: Int): Node = {
      if (offset <= 0) return null
      (x until x + offset).foreach(i => (y until y + offset).foreach(j => if (grid(i)(j) != grid(x)(y)) {
        return new Node(0, false,
          f(grid, x, y, offset / 2),
          f(grid, x, y + offset / 2, offset / 2),
          f(grid, x + offset / 2, y, offset / 2),
          f(grid, x + offset / 2, y + offset / 2, offset / 2))
      }))
      new Node(grid(x)(y), true, null, null, null, null)
    }

    f(grid, 0, 0, grid.length)
  }
}
