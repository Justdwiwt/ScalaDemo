package leetCode

import scala.collection.mutable

object Solution_1162 {
  def maxDistance(grid: Array[Array[Int]]): Int = {
    val q = new mutable.Queue[Point]()
    grid.indices.foreach(i => grid(0).indices.foreach(j => if (grid(i)(j) == 1) q.enqueue(new Point(i, j, 0))))
    if (q.isEmpty || q.length == grid.length * grid(0).length) return -1
    var p: Point = null
    while (q.nonEmpty) {
      p = q.front
      q.dequeue()
      val x = p.x
      val y = p.y
      val step = p.step
      if (x + 1 < grid.length && grid(x + 1)(y) == 0) {
        grid(x + 1)(y) = 1
        q.enqueue(new Point(x + 1, y, step + 1))
      }
      if (x - 1 >= 0 && grid(x - 1)(y) == 0) {
        grid(x - 1)(y) = 1
        q.enqueue(new Point(x - 1, y, step + 1))
      }
      if (y + 1 < grid(0).length && grid(x)(y + 1) == 0) {
        grid(x)(y + 1) = 1
        q.enqueue(new Point(x, y + 1, step + 1))
      }
      if (y - 1 >= 0 && grid(x)(y - 1) == 0) {
        grid(x)(y - 1) = 1
        q.enqueue(new Point(x, y - 1, step + 1))
      }
    }
    p.step
  }

  class Point(a: Int, b: Int, c: Int) {
    var x: Int = a
    var y: Int = b
    var step: Int = c
  }

}
