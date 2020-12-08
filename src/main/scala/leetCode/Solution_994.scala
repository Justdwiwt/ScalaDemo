package leetCode

object Solution_994 {
  def orangesRotting(grid: Array[Array[Int]]): Int = solver(grid, 0)

  @scala.annotation.tailrec
  def solver(grid: Array[Array[Int]], acc: Int): Int = {
    val tbr = grid.indices.map(x => grid.head.indices.withFilter(y => grid(x)(y) == 1 && isAdjRot((x, y), grid)).map(y => (x, y)).toList).toList.reduce(_ ::: _)

    if (tbr.isEmpty)
      if (grid.map(_.contains(1)).reduce(_ || _)) -1 else acc
    else {
      tbr.foreach(x => grid(x._1)(x._2) = 2)
      solver(grid, acc + 1)
    }
  }

  def isAdjRot(pos: (Int, Int), grid: Array[Array[Int]]): Boolean = {
    val offset = Array((1, 0), (0, 1), (-1, 0), (0, -1))
    offset.map(x => {
      val np = (pos._1 + x._1, pos._2 + x._2)
      if (isInbound(np, grid)) grid(np._1)(np._2) == 2 else false
    }).reduce(_ || _)
  }

  def isInbound(np: (Int, Int), grid: Array[Array[Int]]): Boolean = np._1 >= 0 && np._2 >= 0 && np._1 < grid.length && np._2 < grid.head.length

}
