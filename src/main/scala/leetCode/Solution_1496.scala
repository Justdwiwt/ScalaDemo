package leetCode

import scala.collection.mutable

object Solution_1496 {
  def isPathCrossing(path: String): Boolean = {
    if (path == null || path.isEmpty) return false
    val s = new mutable.HashSet[String]()
    var x = 0
    var y = 0
    s.add(x + "-" + y)
    path.toCharArray.foreach(c => {
      c match {
        case 'N' => y += 1
        case 'E' => x -= 1
        case 'S' => y -= 1
        case 'W' => x += 1
        case _ =>
      }
      if (s.contains(x + "-" + y)) return true
      s.add(x + "-" + y)
    })
    false
  }
}

case class Point(x: Int, y: Int) {
  def +(that: Point): Point = Point(x + that.x, y + that.y)

  def -(that: Point): Point = Point(x - that.x, y - that.y)
}

object Solution_1496_2 {

  val M = Map('N' -> Point(0, -1), 'S' -> Point(0, 1), 'E' -> Point(1, 0), 'W' -> Point(-1, 0))

  def isPathCrossing(path: String): Boolean = {
    @scala.annotation.tailrec
    def f(l: List[Char], cur: Point, vis: Set[Point]): Boolean = l match {
      case Nil => false
      case h :: t => if (vis.contains(cur + M(h))) true else f(t, cur + M(h), vis + (cur + M(h)))
    }

    f(path.toList, Point(0, 0), Set(Point(0, 0)))
  }
}
