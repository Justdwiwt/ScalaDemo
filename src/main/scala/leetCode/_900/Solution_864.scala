package leetCode._900

object Solution_864 {
  def shortestPathAllKeys(grid: Array[String]): Int = {
    var keys = 0
    var start = 0
    grid.indices.foreach(i => grid.head.indices.foreach(j => {
      if (('a' to 'f').contains(grid(i)(j))) keys += (1 << (grid(i)(j) - 'a'))
      if (grid(i)(j) == '@') start = i * grid.head.length + j
    }))

    val visited = Array.fill(grid.length * grid.head.length)(Array.fill(keys)(false))
    val q = collection.mutable.Queue[(Int, Int)]((start, 0))
    visited(start)(0) = true
    var steps = 0

    while (q.nonEmpty) {
      val len = q.length
      (1 to len).foreach(_ => {
        val (loc, state) = q.dequeue()
        if (state == keys) return steps
        val (i, j) = (loc / grid.head.length, loc % grid.head.length)
        List((-1, 0), (1, 0), (0, 1), (0, -1)).foreach(d => {
          val x = i + d._1
          val y = j + d._2
          if (x >= 0 && x < grid.length && y >= 0 && y < grid.head.length && grid(x)(y) != '#')
            if ((('A' to 'Z') contains grid(x)(y)) && ((state & (1 << grid(x)(y) - 'A')) == 0)) {}
            else {
              var nextState = 0
              if (('a' to 'f').contains(grid(x)(y))) nextState = state | (1 << (grid(x)(y) - 'a'))
              else nextState = state
              if (nextState == keys) return steps + 1
              if (!visited(x * grid.head.length + y)(nextState)) {
                q += ((x * grid.head.length + y, nextState))
                visited(x * grid.head.length + y)(nextState) = true
              }
            }
        })
      })
      steps += 1
    }
    -1
  }
}
