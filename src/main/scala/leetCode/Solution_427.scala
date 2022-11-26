package leetCode

object Solution_427 {
  class Node(var _value: Boolean, var _isLeaf: Boolean) {
    var value: Boolean = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = _
    var topRight: Node = _
    var bottomLeft: Node = _
    var bottomRight: Node = _
  }

  def construct(grid: Array[Array[Int]]): Node = {
    val cnt = Array.fill[Array[Int]](grid.length)(Array.ofDim[Int](grid.length))
    grid.indices.foreach(y => grid.head.indices.foreach(x => {
      val value = grid(y)(x)
      val pre =
        if (y == 0 && x == 0) 0
        else if (y == 0) cnt(y)(x - 1)
        else if (x == 0) cnt(y - 1)(x)
        else cnt(y)(x - 1) + cnt(y - 1)(x) - cnt(y - 1)(x - 1)
      cnt(y)(x) = value + pre
    }))
    buildTree(cnt, 0 -> 0, (grid.length - 1) -> (grid.length - 1)).orNull
  }

  def buildTree(cnt: Array[Array[Int]], p0: (Int, Int), p1: (Int, Int)): Option[Node] = {
    if (p0._1 > p1._1 || p0._2 > p1._2) None
    else {
      val (ones, zeros) = oneAndZerosInSquare(cnt, p0, p1)
      if (ones == 0 || zeros == 0) Some(new Node(zeros == 0, true))
      else {
        val res = new Node(true, false)
        val (topLeft0, topLeft1) = quadrant(p0, p1, -1, -1)
        val (topRight0, topRight1) = quadrant(p0, p1, -1, 1)
        val (bottomRight0, bottomRight1) = quadrant(p0, p1, 1, 1)
        val (bottomLeft0, bottomLeft1) = quadrant(p0, p1, 1, -1)
        res.topLeft = buildTree(cnt, topLeft0, topLeft1).orNull
        res.topRight = buildTree(cnt, topRight0, topRight1).orNull
        res.bottomRight = buildTree(cnt, bottomRight0, bottomRight1).orNull
        res.bottomLeft = buildTree(cnt, bottomLeft0, bottomLeft1).orNull
        Some(res)
      }
    }
  }

  private def quadrant(p0: (Int, Int), p1: (Int, Int), qy: Int, qx: Int): ((Int, Int), (Int, Int)) = {
    val middleRightY = ((p1._1 - p0._1 + 1) >> 1) + p0._1
    val middleLeftY = middleRightY - 1
    val middleRightX = ((p1._2 - p0._2 + 1) >> 1) + p0._2
    val middleLeftX = middleRightX - 1
    var r0Y = 0
    var r0X = 0
    var r1Y = 0
    var r1X = 0
    if (qy < 0) {
      r0Y = p0._1
      r1Y = middleLeftY
    } else {
      r0Y = middleRightY
      r1Y = p1._1
    }
    if (qx < 0) {
      r0X = p0._2
      r1X = middleLeftX
    } else {
      r0X = middleRightX
      r1X = p1._2
    }
    (r0Y -> r0X) -> (r1Y -> r1X)
  }

  private def oneAndZerosInSquare(cnt: Array[Array[Int]], p0: (Int, Int), p1: (Int, Int)): (Int, Int) = {
    val (y0, x0) = p0
    val (y1, x1) = p1
    var res = cnt(y1)(x1)
    if (x0 > 0) res -= cnt(y1)(x0 - 1)
    if (y0 > 0) res -= cnt(y0 - 1)(x1)
    if (x0 > 0 && y0 > 0) res += cnt(y0 - 1)(x0 - 1)
    (res, (y1 - y0 + 1) * (x1 - x0 + 1) - res)
  }
}
