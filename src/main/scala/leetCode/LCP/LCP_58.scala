package leetCode.LCP

import scala.collection.mutable

object LCP_58 {
  private var n: Int = _
  private val r8: Array[Array[Int]] = Array(
    Array(1, 0, 0, 0, 0, 0, 1, 0), Array(0, 0, 1, 0, 0, 1, 0, 0), Array(0, 1, 0, 0, 0, 0, 0, 1), Array(0, 0, 0, 1, 1, 0, 0, 0),
    Array(1, 0, 0, 0, 0, 0, 0, 1), Array(0, 0, 1, 0, 1, 0, 0, 0), Array(0, 1, 0, 0, 0, 0, 1, 0), Array(0, 0, 0, 1, 0, 1, 0, 0)
  )

  private var csm: mutable.Map[Int, mutable.Map[Int, mutable.Map[Int, mutable.Set[Int]]]] = _

  def composeCube(shapes: Array[Array[String]]): Boolean = {
    n = shapes.head.length
    var cnt1 = 0
    shapes.foreach(sArr => sArr.foreach(s => cnt1 += s.count(_ == '1')))
    if (cnt1 != (n * n * n - (n - 2) * (n - 2) * (n - 2)))
      return false

    val points = createPoints(shapes.head, 0, 0)
    csm = mutable.HashMap.empty
    (1 until 6).foreach(i => (1 until 6).foreach(side => (0 until 8).foreach(ro => {
      val pts = createPoints(shapes(i), side, ro)
      csm
        .getOrElseUpdate(i, mutable.HashMap.empty)
        .getOrElseUpdate(side, mutable.HashMap.empty)
        .getOrElseUpdate(ro, mutable.HashSet.empty) ++= pts
    })))
    dfs(points, 1, Array.fill(6)(false))
  }

  private def dfs(points: mutable.Set[Int], side: Int, cs: Array[Boolean]): Boolean = {
    if (side > 5) true
    else {
      var found = false
      var next = 1
      while (next < 6 && !found) {
        if (!cs(next)) {
          cs(next) = true
          var ro = 0
          while (ro < 8 && !found) {
            val ns = csm(next)(side)(ro)
            val nextPoints = points ++ ns
            if (nextPoints.size == points.size + ns.size) found = dfs(nextPoints, side + 1, cs)
            ro += 1
          }
          cs(next) = false
        }
        next += 1
      }
      found
    }
  }


  private def createPoints(shape: Array[String], side: Int, rotate: Int): mutable.Set[Int] = {
    val res = mutable.HashSet.empty[Int]
    val rr = r8(rotate)

    (0 until n).foreach(i => (0 until n).foreach(j => {
      val r = rr(0) * i + rr(1) * (n - 1 - i) + rr(2) * j + rr(3) * (n - 1 - j)
      val c = rr(4) * i + rr(5) * (n - 1 - i) + rr(6) * j + rr(7) * (n - 1 - j)
      if (shape(r)(c) == '1') side match {
        case 0 => res += offset(i, j, 0)
        case 1 => res += offset(0, i, j)
        case 2 => res += offset(n - 1, i, j)
        case 3 => res += offset(i, 0, j)
        case 4 => res += offset(i, n - 1, j)
        case 5 => res += offset(i, j, n - 1)
      }
    }))
    res
  }

  private def offset(x: Int, y: Int, z: Int): Int =
    (x * 100) + (y * 10) + z
}
