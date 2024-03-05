package leetCode

object Solution_803 {

  case class Point(x: Int, y: Int) {
    def +(p: Point): Point = Point(x + p.x, y + p.y)
  }

  private def diff: List[Point] =
    List(Point(-1, 0), Point(1, 0), Point(0, 1), Point(0, -1))

  def hitBricks(grid: Array[Array[Int]], hits: Array[Array[Int]]): Array[Int] = {
    var res = List.empty[Int]

    def inBound(p: Point): Boolean =
      grid.indices.contains(p.x) && grid(p.x).indices.contains(p.y)

    @scala.annotation.tailrec
    def dfs(l: List[Point], path: List[Point] = Nil): List[Point] = l match {
      case Nil => path
      case h :: t =>
        if (!inBound(h) || grid(h.x)(h.y) == 0) dfs(t, path)
        else dfs(diff.map(_ + h).filterNot(path.contains) ++ t, h :: path)
    }

    def f(l: Array[Point]): Int = {
      val visited = Array.fill(4)(List.empty[Point])
      (0 to 3)
        .map { i => val p = l(i); (i, p) }
        .withFilter { case (_, p) => inBound(p) }
        .foreach { case (i, p) => if (!visited.slice(0, i).exists(_.contains(p))) visited(i) = dfs(List(p)).distinct }
      var acc = 0
      visited.foreach(points => {
        if (!points.exists(_.x == 0)) {
          acc += points.length
          points.foreach({ case Point(a, b) => grid(a)(b) = 0 })
        }
      })
      acc
    }

    hits.foreach { case Array(x, y) =>
      grid(x)(y) = 0
      val l = diff.map(_ + Point(x, y))
      res ::= f(l.toArray)
    }

    res.reverse.toArray
  }

}
