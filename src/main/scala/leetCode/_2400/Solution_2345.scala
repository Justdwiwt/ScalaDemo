package leetCode._2400

import scala.collection.mutable

object Solution_2345 {
  def visibleMountains(peaks: Array[Array[Int]]): Int = {
    val cnt = mutable.Map.empty[(Int, Int), Int].withDefaultValue(0)
    val st = mutable.Set.empty[(Int, Int)]

    peaks.foreach(peak => {
      val x = peak.head
      val y = peak(1)
      st.add((x - y, x + y))
      cnt((x - y, x + y)) += 1
    })

    val sorted = st.toList.sortBy(r => (r._1, -r._2))

    val (_, res) = sorted.foldLeft((0, 0)) { case ((mx, count), (x, y)) =>
      if (y <= mx) (mx, count)
      else if (cnt((x, y)) > 1) (mx.max(y), count)
      else (mx.max(y), count + 1)
    }

    res
  }
}
