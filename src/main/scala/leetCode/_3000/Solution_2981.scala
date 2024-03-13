package leetCode._3000

import scala.collection.mutable

object Solution_2981 {
  def maximumLength(s: String): Int = {
    val map = mutable.Map.empty[String, Int]
    s.indices.foreach(i => (i + 1 to s.length).foreach(j => {
      val t = s.substring(i, j)
      if (t.distinct.length == 1) map.update(t, map.getOrElse(t, 0) + 1)
    }))
    scala.util.Try(map.filter(_._2 >= 3).map(_._1.length).max).getOrElse(-1)
  }
}
