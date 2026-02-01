package leetCode._3800

object Solution_3796 {
  def findMaxVal(n: Int, restrictions: Array[Array[Int]], diff: Array[Int]): Int = {
    val INF = Int.MaxValue / 2
    val maxVal = restrictions.foldLeft(Vector.fill(n)(INF))((v, r) => v.updated(r(0), r(1)))
    val forward = diff.indices.foldLeft(Vector(0))((a, i) => a :+ math.min(a.last + diff(i), maxVal(i + 1)))
    val finalArr = (n - 2 to 0 by -1).foldLeft(forward)((a, i) => a.updated(i, math.min(a(i), a(i + 1) + diff(i))))
    finalArr.max
  }
}
