package leetCode

object Solution_490 {
  def hasPath(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Boolean = {
    f(maze, start, destination)
  }

  def f(maze: Array[Array[Int]], start: Array[Int], dest: Array[Int]): Boolean = {
    if (maze(start.head)(start(1)) != 0) return false
    if (start.head == dest.head && start(1) == dest(1)) return true

    maze(start.head)(start(1)) = 2
    var l = start(1) - 1
    var r = start(1) + 1
    var u = start.head - 1
    var v = start.head + 1

    while (l >= 0 && maze(start.head)(l) != 1) l -= 1
    if (f(maze, Array(start.head, l + 1), dest)) return true

    while (r < maze.head.length && maze(start.head)(r) != 1) r += 1
    if (f(maze, Array(start.head, r - 1), dest)) return true

    while (u >= 0 && maze(u)(start(1)) != 1) u -= 1
    if (f(maze, Array(u + 1, start(1)), dest)) return true

    while (v < maze.length && maze(v)(start(1)) != 1) v += 1
    if (f(maze, Array(v - 1, start(1)), dest)) return true

    false
  }
}
