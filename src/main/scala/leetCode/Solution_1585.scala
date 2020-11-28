package leetCode

import scala.collection.mutable

object Solution_1585 {
  def isTransformable(s: String, t: String): Boolean = {
    val diff = Array.fill(10)(mutable.ArrayBuffer[Int]())
    s.indices.foreach(i => diff(s(i).toString.toInt).append(i))
    val arr = Array.fill(10)(0)
    t.indices.foreach(i => {
      val n = t(i).toString.toInt
      arr.update(n, arr(n) + 1)
      if (diff(n).length < arr(n)) return false
      if (i > 0 && t(i) < t(i - 1)) {
        val b = t(i - 1).toString.toInt
        if (diff(n)(arr(n) - 1) < diff(b)(arr(b) - 1)) return false
      }
    })
    true
  }
}
