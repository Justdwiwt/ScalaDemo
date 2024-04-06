package leetCode._400

import scala.collection.mutable

object Solution_356 {
  def isReflected(points: Array[Array[Int]]): Boolean = {
    var mn = Int.MaxValue
    var mx = Int.MinValue
    val st = mutable.HashSet.empty[String]

    points.foreach(p => {
      mn = mn.min(p.head)
      mx = mx.max(p.head)
      st += s"${p.head}a${p(1)}"
    })

    val sum = mn + mx
    points.forall(p => st.contains(s"${sum - p.head}a${p(1)}"))
  }
}
