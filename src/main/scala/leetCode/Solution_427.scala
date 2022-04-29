package leetCode

object Solution_427 {

  class Node(var _value: Boolean, var _isLeaf: Boolean) {
    var value: Boolean = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = _
    var topRight: Node = _
    var bottomLeft: Node = _
    var bottomRight: Node = _

    def this(_value: Boolean, _isLeaf: Boolean,
             _topLeft: Node,
             _topRight: Node,
             _bottomLeft: Node,
             _bottomRight: Node) {
      this(_value, _isLeaf)
      this.topLeft = _topLeft
      this.topRight = _topRight
      this.bottomLeft = _bottomLeft
      this.bottomRight = _bottomRight
    }
  }


  var arr = Array.empty[Array[Int]]

  def construct(grid: Array[Array[Int]]): Node = {
    arr = Array.fill(grid.length + 1, grid.head.length + 1)(0)
    grid.indices.foreach(i => grid.head.indices.foreach(j =>
      arr(i + 1)(j + 1) = arr(i + 1)(j) + arr(i)(j + 1) - arr(i)(j) + grid(i)(j)
    ))
    f(0, 0, grid.length, grid.head.length)
  }

  def f(x0: Int, y0: Int, x1: Int, y1: Int): Node = {
    val diff = arr(x1)(y1) - arr(x1)(y0) - arr(x0)(y1) + arr(x0)(y0)
    if (diff == 0) return new Node(false, true, null, null, null, null)
    if (diff == (x1 - x0) * (y1 - y0)) return new Node(true, true, null, null, null, null)
    val hx = (x0 + x1) / 2
    val hy = (y0 + y1) / 2
    new Node(true, false,
      f(x0, y0, hx, hy),
      f(x0, hy, hx, y1),
      f(hx, y0, x1, hy),
      f(hx, hy, x1, y1))
  }
}
