package leetCode._600

import scala.collection.mutable.ArrayBuffer

object Solution_587 {
  case class Point(var _x: Int, var _y: Int) {
    var x: Int = _x
    var y: Int = _y
  }

  def outerTrees(points: Array[Point]): List[Point] = points match {
    case Array() => List.empty
    case Array(x) => List(x)
    case _ => getSquare(points)
      ./:((Set.empty[Point], points.toSet))(produce)
      ._1
      .toList
  }

  private def getSquare(points: Array[Point]): Array[(Point, Point)] = {
    val x = points./:((points.head, points.head, points.head, points.head))((m, p) => (
      if (m._1.x > p.x) p else m._1,
      if (m._2.x < p.x) p else m._2,
      if (m._3.y > p.y) p else m._3,
      if (m._4.y < p.y) p else m._4
    ))
    Array((x._1, x._4), (x._4, x._2), (x._2, x._3), (x._3, x._1)).filter(e => e._1 != e._2)
  }

  private def produce(data: (Set[Point], Set[Point]), edge: (Point, Point)): (Set[Point], Set[Point]) = {
    val groupedP = data._2.groupBy(height(edge)(_).signum)
    val outside = groupedP.getOrElse(1, Set.empty[Point])
    val onEdge = groupedP.getOrElse(0, Set.empty[Point])

    if (outside.isEmpty) (data._1 ++ onEdge, data._2 -- onEdge)
    else {
      val res = (
        outside
          .groupBy(sortP(edge))
          .map(_._2.maxBy(height(edge)))
          .toSeq
          .sortBy(sortP(edge))
          :+ edge._2
        )
        ./:(Seq[Point](edge._1))(procP(edge))

      (data._1 ++ res, groupedP.getOrElse(-1, onEdge))
    }
  }

  private def height(edge: (Point, Point))(p: Point): Int =
    (edge._2.x - edge._1.x) * (p.y - edge._1.y) - (p.x - edge._1.x) * (edge._2.y - edge._1.y)

  private def sortP(edge: (Point, Point))(p: Point): Int =
    (edge._2.x - edge._1.x) * (p.x - edge._1.x) + (edge._2.y - edge._1.y) * (p.y - edge._1.y)

  private def procP(edge: (Point, Point))(ans: Seq[Point], p: Point): Seq[Point] =
    p +: remove(ans, p)

  @scala.annotation.tailrec
  private def remove(res: Seq[Point], p: Point): Seq[Point] =
    if (res.size > 1 && height((res(1), p))(res.head) < 0) remove(res.drop(1), p)
    else res
}

object Solution_587_2 {
  def outerTrees(points: Array[Array[Int]]): Array[Array[Int]] = {
    var first = 0

    points
      .indices
      .drop(1)
      .withFilter(points(_).head < points(first).head)
      .foreach(first = _)

    val flag = Array.fill(points.length)(false)

    flag(first) = true

    var cur = first

    var next = 0

    points
      .indices
      .drop(1)
      .withFilter(_ != cur)
      .foreach(i => {
        val c = f(points(i), points(cur), points(next))
        if (next == cur || c > 0 || (c == 0 && g(points(i), points(cur)) > g(points(next), points(cur))))
          next = i
      })

    points
      .indices
      .withFilter(!flag(_))
      .map { i => val c = f(points(i), points(cur), points(next)); (i, c) }
      .withFilter { case (_, c) => c == 0 }
      .foreach { case (i, _) => flag(i) = true }

    cur = next

    while (cur != first) {
      var next = 0

      points
        .indices
        .drop(1)
        .withFilter(_ != cur)
        .foreach(i => {
          val c = f(points(i), points(cur), points(next))
          if (next == cur || c > 0 || (c == 0 && g(points(i), points(cur)) > g(points(next), points(cur))))
            next = i
        })

      points
        .indices
        .withFilter(!flag(_))
        .map { i => val c = f(points(i), points(cur), points(next)); (i, c) }
        .withFilter { case (_, c) => c == 0 }
        .foreach { case (i, _) => flag(i) = true }

      cur = next
    }

    val res = ArrayBuffer.empty[Array[Int]]

    points
      .indices
      .withFilter(flag(_))
      .foreach(res += points(_))

    res.toArray
  }

  private def f(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val bax = b(0) - a(0)
    val bay = b(1) - a(1)
    val bcx = c(0) - b(0)
    val bcy = c(1) - b(1)

    bax * bcy - bcx * bay
  }

  private def g(a: Array[Int], b: Array[Int]): Int = {
    val x = a(0) - b(0)
    val y = a(1) - b(1)
    x * x + y * y
  }
}
