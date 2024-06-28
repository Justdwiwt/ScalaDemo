package leetCode._800

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_711 {
  var grid: Array[Array[Int]] = _
  var seen: Array[Array[Boolean]] = _
  var shape: ArrayBuffer[Int] = _

  private def explore(r: Int, c: Int): Unit = {
    if (0 <= r && r < grid.length && 0 <= c && c < grid.head.length &&
      grid(r)(c) == 1 && !seen(r)(c)) {
      seen(r)(c) = true
      shape += r * grid.head.length + c
      explore(r + 1, c)
      explore(r - 1, c)
      explore(r, c + 1)
      explore(r, c - 1)
    }
  }

  private def canonical(shape: ArrayBuffer[Int]): String = {
    var res = ""
    val lift = grid.length + grid.head.length
    val out = new Array[Int](shape.length)
    val xs = new Array[Int](shape.length)
    val ys = new Array[Int](shape.length)

    (0 until 8).foreach(c => {
      var t = 0
      shape.foreach(z => {
        val x = z / grid.head.length
        val y = z % grid.head.length
        xs(t) = if (c <= 1) x else if (c <= 3) -x else if (c <= 5) y else -y
        ys(t) = if (c <= 3) if (c % 2 == 0) y else -y else if (c % 2 == 0) x else -x
        t += 1
      })

      val mx = xs.min
      val my = ys.min

      shape.indices.foreach(j => out(j) = (xs(j) - mx) * lift + (ys(j) - my))
      val candidate = out.sorted.mkString(",")
      if (res < candidate) res = candidate
    })
    res
  }

  def numDistinctIslands2(grid: Array[Array[Int]]): Int = {
    this.grid = grid
    seen = Array.ofDim[Boolean](grid.length, grid.head.length)
    val st = mutable.Set.empty[String]

    grid.indices.foreach(r => grid.head.indices.foreach(c => {
      shape = ArrayBuffer()
      explore(r, c)
      if (shape.nonEmpty) st += canonical(shape)
    }))

    st.size
  }
}
