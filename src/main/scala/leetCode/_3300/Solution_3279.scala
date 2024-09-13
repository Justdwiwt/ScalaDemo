package leetCode._3300

import scala.collection.mutable

object Solution_3279 {
  def maxArea(height: Int, positions: Array[Int], directions: String): Long = {
    val m = mutable.Map.empty[Int, Int].withDefaultValue(0)
    var r = BigInt(0)
    var tmp = BigInt(0)

    positions.indices.foreach(i => {
      val p = positions(i)
      if (directions(i) == 'D') {
        m(p) += 2
        m(p + height) -= 2
        tmp -= 1
        r += p
      } else {
        m(height - p) -= 2
        m(2 * height - p) += 2
        tmp += 1
        r += p
      }
    })

    val sorted = m.keys.toSeq.sorted
    var pre = 0
    var res = r

    sorted.foreach(t => {
      r += BigInt(t - pre) * tmp
      pre = t
      tmp += m(t)
      res = res.max(r)
    })

    res.longValue()
  }
}
