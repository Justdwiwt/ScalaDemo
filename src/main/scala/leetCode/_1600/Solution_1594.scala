package leetCode._1600

object Solution_1594 {
  def maxProductPath(grid: Array[Array[Int]]): Int = {
    val arr = Array.fill[List[Long]](grid.length, grid.head.length)(Nil)
    arr(0)(0) = List(1L)
    grid.indices.foreach(r => grid.head.indices.foreach(c =>
      if (r == 0 && c == 0) arr(0)(0) = List(grid.head.head)
      else {
        val t = if (r == 0) Nil else arr(r - 1)(c)
        val l = if (c == 0) Nil else arr(r)(c - 1)
        val v = grid(r)(c)
        val values = (t.map(_ * v) ::: l.map(_ * v)).sorted
        val mn = values.head
        val mx = values.last
        arr(r)(c) =
          if ((mn < 0 && mx >= 0) || (mn <= 0 && mx > 0)) List(mn, mx)
          else if (mn < 0) List(mn)
          else List(mx)
      }))
    val res = arr(grid.length - 1)(grid.head.length - 1).last
    if (res < 0) -1 else (res % 1000000007).toInt
  }
}
