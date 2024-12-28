package leetCode._2000

import scala.math._
import scala.util.Random

object Solution_1924 {
  case class Point(x: Double, y: Double) {
    def dist2(q: Point): Double = pow(x - q.x, 2) + pow(y - q.y, 2)
  }

  def outerTrees(trees: Array[Array[Int]]): Array[Double] = {
    if (trees.length <= 1) {
      if (trees.isEmpty) return Array(0.0, 0.0, 0.0)
      return Array(trees.head.head.toDouble, trees.head(1).toDouble, 0.0)
    }

    val shuffledTrees = Random.shuffle(trees.toSeq).map(arr => Point(arr.head.toDouble, arr(1).toDouble)).toArray

    var o = shuffledTrees.head
    var r2 = 0.0

    shuffledTrees.indices.foreach(i => {
      val p = shuffledTrees(i)
      if (o.dist2(p) > r2 + 1e-9) {
        o = p
        r2 = 0.0
        (0 until i).foreach(j => {
          val q = shuffledTrees(j)
          if (o.dist2(q) > r2 + 1e-9) {
            o = Point((p.x + q.x) / 2, (p.y + q.y) / 2)
            r2 = o.dist2(p)
            (0 until j).foreach(k => {
              val x = shuffledTrees(k)
              if (o.dist2(x) > r2 + 1e-9) {
                val tmp = getCircle(p, q, x)
                o = Point(tmp.head, tmp(1))
                r2 = o.dist2(p)
              }
            })
          }
        })
      }
    })
    Array(o.x, o.y, sqrt(r2))
  }

  private def getCircle(a: Point, b: Point, c: Point): Array[Double] = {
    val a1 = b.x - a.x
    val b1 = b.y - a.y
    val a2 = c.x - a.x
    val b2 = c.y - a.y
    val c1 = a1 * a1 + b1 * b1
    val c2 = a2 * a2 + b2 * b2
    val d = 2 * (a1 * b2 - a2 * b1)
    if (abs(d) < 1e-9) {
      val ab2 = a.dist2(b)
      val bc2 = b.dist2(c)
      val ca2 = c.dist2(a)
      if (ab2 >= bc2 && ab2 >= ca2) Array((a.x + b.x) / 2, (a.y + b.y) / 2, sqrt(ab2) / 2)
      else if (bc2 >= ab2 && bc2 >= ca2) Array((b.x + c.x) / 2, (b.y + c.y) / 2, sqrt(bc2) / 2)
      else Array((c.x + a.x) / 2, (c.y + a.y) / 2, sqrt(ca2) / 2)
    } else {
      val centerX = a.x + (c1 * b2 - c2 * b1) / d
      val centerY = a.y + (a1 * c2 - a2 * c1) / d
      Array(centerX, centerY, sqrt(a.dist2(Point(centerX, centerY))))
    }
  }
}
