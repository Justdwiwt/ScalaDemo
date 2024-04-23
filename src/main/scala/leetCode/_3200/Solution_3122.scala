package leetCode._3200

object Solution_3122 {
  def minimumOperations(grid: Array[Array[Int]]): Int = {
    var f0 = 0
    var f1 = 0
    var pre = -1
    grid.transpose.foreach(col => {
      var mx = f0
      var mx2 = 0
      var x = -1
      val cnt = col.groupBy(identity).mapValues(_.length)
      cnt.foreach { case (v, c) =>
        val res = if (v != pre) f0 + c else f1 + c
        if (res > mx) {
          mx2 = mx
          x = v
          mx = res
        } else if (res > mx2) mx2 = res
      }
      f0 = mx
      f1 = mx2
      pre = x
    })
    grid.length * grid.head.length - f0
  }
}
