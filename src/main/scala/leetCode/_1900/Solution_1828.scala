package leetCode._1900

object Solution_1828 {
  case class Point(x: Int, y: Int) {
    def -(q: Point): Point = Point(x - q.x, y - q.y)

    def dot: Int = x * x + y * y
  }

  case class Circle(p: Point, r2: Int)

  def countPoints(points: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val P = points.map({ case Array(x, y) => Point(x, y) })
    val Q = queries.map({ case Array(x, y, r) => Circle(Point(x, y), r * r) })

    def compute(c: Circle): Int = {
      def inside(p: Point): Boolean =
        (p - c.p).dot <= c.r2

      P.count(inside)
    }

    Q.map(compute)
  }
}
